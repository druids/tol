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
[tol "0.2.0"]
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

Contribution
------------

### Conventions

* Please follow coding style defined by [`.editorconfig`](http://editorconfig.org)
 and [The Clojure Style Guide](https://github.com/bbatsov/clojure-style-guide)
* Write [good commit messages](https://chris.beams.io/posts/git-commit/)
 and provide an issue ID in a commit message prefixed by `#`
