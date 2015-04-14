(ns prime-challenge.core-test
  (:require [clojure.test :refer :all]
            [prime-challenge.core :refer :all]))

(deftest divisible-in?-test
  (is (= true (divisible-in? 2 #{1 2})))
  (is (= true (divisible-in? 2 #{1})))
  (is (= false (divisible-in? 5 #{2 3 4})))
  (is (= true (divisible-in? 30 #{2 3 4}))))

(deftest test-primality-test
  (is (= true (test-primality 2 #{})))
  (is (= false (test-primality 2 #{2})))
  (is (= true (test-primality 29 #{})))
  (is (= false (test-primality 30 #{})))
  (is (= true (test-primality 31 #{}))))

(deftest prime?-test
  (testing "A prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself."
    (is (= false (prime? -1)))
    (is (= false (prime? 0)))
    (is (= false (prime? 1)))
    (is (= true (prime? 2)))
    (is (= true (prime? 3)))
    (is (= false (prime? 4)))
    (is (= true (prime? 5)))
    (is (= false (prime? 6)))
    (is (= true (prime? 7)))
    (is (= true (prime? 31)))
    (is (= false (prime? 32)))))

(deftest multiplication-table-test
  (is (= [{nil 1 1 (* 1 1) 2 (* 1 2)}
          {nil 2 1 (* 2 1) 2 (* 2 2)}]
         (multiplication-table [1 2]))))
