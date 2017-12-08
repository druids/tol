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
