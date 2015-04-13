(ns prime-challenge.core
  (:require [clojure.core.async :as async]))

(def known-primes #{2, 3, 5, 7, 11, 13, 17, 19, 23, 29})

(defn divisible-in?
  "returns true if any of the numbers in the collection are divisible by n"
  [n coll]
  (boolean (some #(= 0 (rem n %)) coll)))

(defn test-primality
  "returns true if n is divisible by one of the known primes or is not divisible by any m from 2 to n - 1"
  [n known-primes]
  (not (or (divisible-in? n known-primes)
           (divisible-in? n (range 2 n)))))

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
      (test-primality n known-primes))

    (boolean (some #{n} known-primes))))
