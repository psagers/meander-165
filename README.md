Reproduces [meander issue #165](https://github.com/noprompt/meander/issues/165)

From my shell (cleaned up a little):

    > clojure -M:shadow compile node
    [:node] Compiling ...
    [:node] Build completed. (79 files, 78 compiled, 0 warnings, 12.26s)

    > node build/user.js 1 2
    1 - [:okay 2]
    2 - [:fail]

    > grep unquote .shadow-cljs/builds/node/dev/out/cljs-runtime/user.js

    > rm -r .shadow-cljs

    > clojure -A:guardrails -M:shadow compile node
    [:node] Compiling ...
    GUARDRAILS IS ENABLED. RUNTIME PERFORMANCE WILL BE AFFECTED.
    Mode: :runtime  Async? false  Throw? false
    Guardrails was enabled because the guardrails.enabled property is set to a (any) value.
    [:node] Build completed. (79 files, 1 compiled, 0 warnings, 5.89s)

    > node build/user.js 1 2
    1 - [:fail]
    2 - [:fail]

    > grep unquote .shadow-cljs/builds/node/dev/out/cljs-runtime/user.js
    if(cljs.core._EQ_.cljs$core$IFn$_invoke$arity$2(new cljs.core.PersistentVector(null, 2, 5, cljs.core.PersistentVector.EMPTY_NODE, [new cljs.core.Symbol(null,"unquote","unquote",-1004694737,null),new cljs.core.Symbol(null,"x","x",-555367584,null)], null),G__28242)){
