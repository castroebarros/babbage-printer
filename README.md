# Babbage Printer

Call the printer directly from your browser through library that uses applet
Java and Javascript.

*Disclaimer: This work is in progress. I first created the documentation for
then start codiing.*

## Why use it?

The browsers have features to you make almost all about printing, like preview
and configure printing options. You even can to use CSS to make the webpage
more pretty when the user want print it.

The issue appears when you need take more the control of the printer, for
example:

* __When you need to call the printer imediatally__ and don't want to show the
  options dialog or preview the document. There is a way to do this using an
  option called "silent" on some browsers, but you must use always the same
  printer.
* __When you need to use specific commands of the printer__ like for example by
  programming in Zebra language. This is common when your are creating an Web
  software for point of sales and your have a receipt printer.

If you are developing a desktop application or can call the printer directly
from the server side, this is NOT for you.

##  How it works?

First you need import the Javascript library:

``` html
<script src="./babbage-printer.js"></script>
```

When the browser load the Javascript it will load too the applet Java
responsible for the communication with the printer.

Then you can call the printer using several options, for example:

``` javascript
babbage.print({
  printer: "My Printer",
  content: "Hello World"
});
```

## References

* [Stack Overflow: Can a Java Applet use the Printer](http://stackoverflow.com/questions/438397/can-a-java-applet-use-the-printer)

