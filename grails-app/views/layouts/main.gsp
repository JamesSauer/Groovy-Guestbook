<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%-- <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/> --%>
    <asset:stylesheet src="application.css"/>
    <title>Hello Zenjob!</title>
    <g:layoutHead/>
</head>
<body>
    <div id="page-wrapper">
        <header id="main-header">
            <h1>Welcome to my <span class="font-Pacifico">groovy</span> guestbook!</h1>
            <p>Leave a message if you like!</p>
            <g:if test="${flash.message}">
                <div class="message">${flash.message}</div>
            </g:if>
        </header>
        <main id="main-column">
            <g:layoutBody/>
        </main>
        <div id="push"></div>
    </div>
    <footer id="main-footer">
        <ul>
            <p>
                A job application by James Sauer.<br>
                Reach me through <a href="mailto:mail@jamessauer.com">mail@jamessauer.com</a>!<br>
                Source code available on <a href="https://github.com/JamesSauer/Groovy-Guestbook">Github</a>.
            </p>
        </ul>
    </footer>
</body>
</html>