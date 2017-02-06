<!DOCTYPE html>
<html>
<head>
    <link href="http://kevinburke.bitbucket.org/markdowncss/markdown.css" rel="stylesheet"></link>
</head>
<body>
<div id="content" data-content="${content}">

</div>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="//cdn.bootcss.com/markdown.js/0.5.0/markdown.min.js"></script>
<script src="//cdn.bootcss.com/marked/0.3.6/marked.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var ct = $("#content");
        var rst = marked(ct.attr("data-content"));
        ct.append(rst);
    });
</script>
</body>
</html>