# version-string

A Clojure library designed to sort strings with numerical order.

[![Clojars Project](http://clojars.org/version-string/latest-version.svg)](http://clojars.org/version-string)

## Usage

```
(require '[version-string.core :refer [sort-by-version]])
(sort-by-version '["a-10.0.tgz" "a-1.0.tgz"])
;==> ("a-1.0.tgz" "a-10.0.tgz")
```

## License

Copyright © 2015 Kazuo Koga

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
