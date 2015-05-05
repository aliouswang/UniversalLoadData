# UniversalLoadData
An universal library help you load data.

What for?

UniversalLoadData can help you load data from internet or android phone disk or database , all those issues is Async, it won't block main thread. And do http request is use https://github.com/loopj/android-async-http, it also can parse response json string to java bean if you needed (use Gson), further more, it can upload files for you.

How to use?

invoke UniversalLoader.getDefault() to get a UniversalLoader singlton object, then you can invoke varies methods ,more details you can see source code.
