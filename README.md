Tól
===

Tól is a set of functions that extend Clojure/ClojureScript core functions. A lot of Clojure core functions are just
 wrappers over Java classes/methods. Thus these functions are more Java-like (they throw `NullPointerException`), but
 this behaviour isn't expected in Clojure world. Clojure's functions for sequences aren't NPE-prone, but others do
 (e.g. `string` module). All Tól functions are designed not to be NPE-prone (rather return `nil`, instead of throw NPE)
 thus they can be used e.g. in `some->` macro.

[![Dependencies Status](https://jarkeeper.com/druids/tol/status.png)](https://jarkeeper.com/druids/tol)
[![License](https://img.shields.io/badge/MIT-Clause-blue.svg)](https://opensource.org/licenses/MIT)
