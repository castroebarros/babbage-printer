# Babbage Printer

Create web applications able to print receipts or coupons using Javascript
and a Java service.

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

We have a simple web service that receive the requests, handles configuring
the printing, and sends the document to the printer.

For example:
http://localhost:4567/pdf?command=Hello world!

```pdf``` is the name of the handler and ```command``` is the content that will 
be printed.


The handlers are configured in a properties file like this:

```
pdf.printer = Cups-PDF
pdf.handler = net.castroebarros.babbage.DefaultHandler
```

So, in our example, our handler is a class that receives that message, creates
a document and sends it to a virtual printer configurated with the name
"Cups-PDF", that we use for testings.

The handlers can already be easily created. Just create a class implementing
the Handler interface, put it on classpath, and configure the
printers.properties file.

Lastly we want create some Javascript codes to make easy the integration
between web application and our Java server.
