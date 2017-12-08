(ns tol.runner
  (:require
    [doo.runner :refer-macros [doo-tests]]
    [tol.core-test]))

(doo-tests
  'tol.core-test)
