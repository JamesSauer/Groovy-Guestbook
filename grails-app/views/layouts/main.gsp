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
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <main id="main-column">
        <g:layoutBody/>
    </main>
    <footer id="main-footer">
        <ul>
            <p>
                A job application by James Sauer.<br>
                Reach me through mail@jamessauer.com!<br>
                Source code available on <a href="#">Github</a>.
                <!-- TODO: Add actual Github link. -->
            </p>
        </ul>
    </footer>
</body>
</html>