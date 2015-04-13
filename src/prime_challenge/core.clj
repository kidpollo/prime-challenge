(ns prime-challenge.core
  (:require [clojure.core.async :as async]))

(def known-primes #{2, 3, 5, 7, 11, 13, 17, 19, 23, 29})

(defn divisible-in? [n coll]
  (boolean (some #(= 0 (rem n %)) coll)))

(defn test-primality [n]
  (if (or (divisible-in? n known-primes)
          (divisible-in? n (range 2 n)))
    false
    true))

(defn- primes-between
  "Finds prime numbers within a range"
  [start end]
  (cond (> start end)
        #{}

        (< start 2)
        (primes-between 2 end)

        :else
        (keep test-primality
              (range start (+ end 1)))))

(defn prime?
  "Returns true if n is prime, otherwise false"
  [n]
  (if (> n (apply max known-primes))
    (do
      ; async add primes to known primes maybe?
      #_(async/thread (primes-between (+ 1 (max known-primes)) n))
      (test-primality n))

    (boolean (some #{n} known-primes))))
