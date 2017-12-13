(ns tol.core-test
  (:require
    #?(:clj [clojure.test :refer [are deftest testing]])
    #?(:cljs [cljs.test :refer-macros [are deftest testing]])
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
            nil nil
            nil ""
            nil " "
            nil "asdf"
            nil "12-"))))

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
