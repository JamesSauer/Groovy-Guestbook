<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="main"/>
</head>
<body>
    <h1>Welcome to my groovy guestbook!</h1>
    <p>Leave a message if you like!</p>
    <ul id="comment-list">
        <g:each in="${entries}" var="entry">
            <li class="entry"> 
                <label for="entry-${entry.id}">${entry.author} on ${entry.creationDate}:</label>
                <p id="entry-${id}" class="font-${entry.font}">${entry.text}</p>
            </li>
        </g:each>
        <li class="entry">
            <form action="/index/addEntry" method="POST" class="font-${font}">
                <input type="text" id="author-input" name="author" class="font-${font}" size="64" placeholder="What's your name?"><br>
                <textarea id="text-input" name="text" class="font-${font}" cols="30" rows="5" maxlength="512" placeholder="Your message here!"></textarea><br>
                <input type="hidden" id="font-input" name="font" value="${font}">
                <button type="submit">Eternalize!</button>
            </form>
        </li>
    </ul>
</body>
</html>