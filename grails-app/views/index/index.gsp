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
            <li> 
                <label for="entry-${entry.id}">${entry.author} on ${entry.creationDate}:</label>
                <p id="entry-${id}" class="font-${entry.font}">${entry.text}</p>
            </li>
        </g:each>
        <li>
            <form action="/eternalize" method="POST">
                <input type="text" id="name-input" name="name" size="30" placeholder="What's your name?"><br>
                <textarea name="text" id="text-input" cols="30" rows="5" placeholder="Your message here!"></textarea><br>
                <button type="submit">Eternalize!</button>
            </form>
        </li>
    </ul>
</body>
</html>