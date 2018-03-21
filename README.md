Tól
===

Tól is a set of functions that extend Clojure/ClojureScript core functions. A lot of Clojure core functions are just
 wrappers over Java classes/methods. Thus these functions are more Java-like (they throw `NullPointerException`), but
 this behaviour isn't expected in Clojure world. Clojure's functions for sequences aren't NPE-prone, but others do
 (e.g. `string` module). All Tól functions are designed not to be NPE-prone (rather return `nil`, instead of throw NPE)
 thus they can be used e.g. in `some->` macro.

[![CircleCI](https://circleci.com/gh/druids/tol.svg?style=svg)](https://circleci.com/gh/druids/tol)
[![Dependencies Status](https://jarkeeper.com/druids/tol/status.png)](https://jarkeeper.com/druids/tol)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)


Leiningen/Boot
--------------

```clojure
[tol "0.6.0"]
```


Documentation
-------------


### ->int
Coerce a given input as an `integer`. If the input is not an `integer` it returns `nil`.

```clojure
(tol/->int 1) ;; 1
(tol/->int "1") ;; 1
(tol/->int nil) ;; nil
(tol/->int "") ;; nil
```

### ->uuid
Coerce a given `value` as `java.util.UUID`. When the `value` is not a valid UUID, it returns `nil`.
In ClojureScript there is not UUID class/function (not even in Google Closure Library). Thus in ClojureScript
it returns just `string` value for non-blank `value`.

```clojure
(tol/->uuid "59537428-0b92-4d3a-9192-bcbae9a18889") ;; #uuid "59537428-0b92-4d3a-9192-bcbae9a18889"
(tol/->uuid nil) ;; nil
(tol/->uuid "") ;; nil
(tol/->uuid "asdf") ;; nil
```

### lowerf
Lower cases first character of a given `value`. It's safe, when the `value` is `nil` or empty `string` returns `nil`,
 otherwise `string.`

```clojure
(tol/lowerf nil) ;; nil
(tol/lowerf "") ;; nil
(tol/lowerf "ABC") ;; "aBC"
```

### upperf
Upper cases first character of a given `value`. It's safe, when the `value` is `nil` or empty `string` returns `nil`,
 otherwise `string.`

```clojure
(tol/upperf nil) ;; nil
(tol/upperf "") ;; nil
(tol/upperf "abC") ;; "AbC"
```

### if-let*
It's if-let with multiple bindings. It allows to flatten and simplify some code nesting.

It doesn't work in ClojureScript.

```clojure
(tol/if-let*
  [a 1
   b (+ a 1)]
  b) ;; 2

(tol/if-let*
  [a 1
   b (+ a 1)
   c false]
  :then
  :else) ;; :else

(tol/if-let*
  [a 1
   b nil]
  a) ;; nil
```

### non-blank
Return a given `input` when it isn't `nil`. Otherwise `nil` is returned. It's useful for `some->` macros.

```clojure
(tol/non-blank nil) ;; nil
(tol/non-blank "") ;; nil
(tol/non-blank " ") ;; nil
(tol/non-blank "abC") ;; "AbC"
```

### update-values
Applies a given function `f` on every value in a given `coll`

```clojure
(tol/update-values inc {:a 0}) ;; {:a 1}
(tol/update-values inc nil) ;; nil
(tol/update-values inc {}) ;; {}
```


Contribution
------------

### Conventions

* Please follow coding style defined by [`.editorconfig`](http://editorconfig.org)
 and [The Clojure Style Guide](https://github.com/bbatsov/clojure-style-guide)
* Write [good commit messages](https://chris.beams.io/posts/git-commit/)
 and provide an issue ID in a commit message prefixed by `#`
