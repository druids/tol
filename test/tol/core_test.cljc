(ns tol.core-test
  (:require
    #?(:clj [clojure.test :refer [are deftest is testing]])
    #?(:cljs [cljs.test :refer-macros [are deftest is testing]])
    [tol.core :as tol])
  #?(:clj
     (:import
       [java.util.UUID])))


(deftest ->int-test
  (testing "should return integer or nil"
    (are [expected value] (= expected (tol/->int value))

         1 1
         1 "1"
         -1 "-1"
         nil "-"
         nil "a"
         nil ""
         nil nil)))


#?(:clj
   (deftest ->uuid-test
     (testing "should return UUID or nil"
       (are [expected value] (= expected (tol/->uuid value))
            (java.util.UUID/fromString "59537428-0b92-4d3a-9192-bcbae9a18889") "59537428-0b92-4d3a-9192-bcbae9a18889"
            (java.util.UUID/fromString "00000000-0000-0000-0000-000000000000") "0-0-0-0-0"
            (java.util.UUID/fromString "59537428-0b92-4d3a-9192-bcbae9a18889") (java.util.UUID/fromString
                                                                                 "59537428-0b92-4d3a-9192-bcbae9a18889")
            nil nil
            nil ""
            nil " "
            nil "asdf"
            nil "12-"
            nil []
            nil 12))))

#?(:cljs
   (deftest ->uuid-test
     (testing "should return UUID or nil"
       (are [expected value] (= expected (tol/->uuid value))
            "59537428-0b92-4d3a-9192-bcbae9a18889" "59537428-0b92-4d3a-9192-bcbae9a18889"
            "0-0-0-0-0" "0-0-0-0-0"
            nil nil
            nil ""
            nil " "
            "asdf" "asdf"
            "12-" "12-"))))


(deftest lowerf-test
  (testing "should lower case first character"
    (are [expected value] (= expected (tol/lowerf value))

         nil nil
         nil ""
         "aBC" "ABC"
         "-" "-")))


(deftest upperf-test
  (testing "should upper case first character"
    (are [expected value] (= expected (tol/upperf value))

         nil nil
         nil ""
         "AbC" "abC"
         "-" "-")))


#?(:clj
   (deftest if-let*-test
     (is (= (tol/if-let*
              [a 1
               b (+ a 1)]
              b)
            2))

     (is (= (tol/if-let*
              [a 1
               b (+ a 1)
               c false]
              :then
              :else)
            :else))

     (is (nil? (tol/if-let*
                 [a 1
                  b nil]
                 a)))))
