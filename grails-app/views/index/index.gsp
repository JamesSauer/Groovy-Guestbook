<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
</head>
<body>
    <ul id="comment-list">
        <li class="entry">
            <form action="/index/addEntry" method="POST">
                <input type="text" id="author-input" name="author" class="font-${font}" size="64" placeholder="What's your name?" required>
                <input type="email" id="email-input" name="email" class="font-${font}" size="128" placeholder="Your email? (Never displayed.)" required>
                <textarea id="text-input" name="text" class="font-${font}" cols="30" rows="1" maxlength="512" placeholder="Your message here!" required></textarea>
                <input type="hidden" id="font-input" name="font" value="${font}">
                <input type="submit" value="Eternalize!">
            </form>
        </li>
        <g:each in="${entries}" var="entry">
            <li class="entry"> 
                <label for="entry-${entry.id}"><span class="font-${entry.font}">${entry.author}</span> on ${entry.creationDate}:</label>
                <p id="entry-${id}" class="font-${entry.font}">${entry.text}</p>
            </li>
        </g:each>
    </ul>
</body>
</html>