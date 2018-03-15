(ns tol.core
  (:require
    [clojure.string :refer [blank? join lower-case upper-case]])
  #?(:clj
     (:import java.util.UUID)))


(defn ->int
  "Coerce a given `value` as integer. If the `value` is not a number, returns `nil`."
  [value]
  (when (->> value str (re-find #"^-?\d+$"))
    #?(:clj (Integer. value))
    #?(:cljs (js/parseInt value 10))))


(defn ->uuid
  "Coerce a given `value` as `java.util.UUID`. When the `value` is not a valid UUID, it returns `nil`.
   In ClojureScript there is not UUID class/function (not even in Google Closure Library). Thus in ClojureScript
   it returns just `string` value for non-blank `value`."
  [value]
  (let [str-value (str value)]
    (when-not (blank? str-value)
      #?(:clj
         (try
           (java.util.UUID/fromString str-value)
           (catch Exception e nil)))
      #?(:cljs
         value))))


(defn- case-first
  [case-fn value]
  (when-not (zero? (count value))
    (let [sanitized-value (str value)]
      (if (< 1 (count sanitized-value))
        (join (cons (-> sanitized-value first case-fn)
                    (subs sanitized-value 1)))
        (case-fn sanitized-value)))))


(def lowerf
  "Lower cases first character of a given `value`. It's safe, when the `value` is `nil` or empty `string` returns `nil`,
   otherwise `string.`"
  (partial case-first lower-case))


(def upperf
  "Upper cases first character of a given `value`. It's safe, when the `value` is `nil` or empty `string` returns `nil`,
   otherwise `string.`"
  (partial case-first upper-case))

#?(:clj
   (defmacro if-let*
     "Taken from https://clojuredocs.org/clojure.core/if-let. It's if-let with multiple bindings.
      It allows to flatten and simplify some code nesting, for instance:
      From
      (if-let [some-x (x)]
        (if-let [some-y (y)]
          (if-let [some-z (z)]
            :found
            :not-found)
          :not-found)
        :not-found)
      into
      (if-let* [some-x (x)
                some-y (y)
                some-z (z)]
        :found
        :not-found)

      It doesn't work in ClojureScript."
     ([bindings then]
      `(if-let* ~bindings ~then nil))
     ([bindings then else]
      (if (seq bindings)
        `(if-let [~(first bindings) ~(second bindings)]
           (if-let* ~(drop 2 bindings) ~then ~else)
           ~else)
        then))))


(defn non-blank
  "Return a given `input` when it isn't `nil`. Otherwise `nil` is returned. It's useful for `some->` macros."
  [input]
  (when-not (blank? input)
    input))
