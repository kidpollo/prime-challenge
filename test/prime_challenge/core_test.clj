(ns prime-challenge.core-test
  (:require [clojure.test :refer :all]
            [prime-challenge.core :refer :all]))

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
    (is (= true (prime? 7)))))
