<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<div>
    <button id="button4" class="btn btn-default" >Button4</button>
    <button id="button5" class="btn btn-default" >Button5</button>
    <button id="button6" class="btn btn-default" >Button6</button>
</div>

<script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.9.1.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

    ga('create', 'UA-92197504-1', 'auto');
    ga('send', 'pageview');

</script>
<script>
    $(document).ready(function () {
        $("#button4").click(function(){
            ga('send', 'event', 'button', 'click', 'button4')
        }).mouseover(function () {
            ga('send', 'event', 'button', 'over', 'button4')
        });
        $("#button5").click(function(){
            ga('send', 'event', 'button', 'click', 'button5');
        }).mouseover(function () {
            ga('send', 'event', 'button', 'over', 'button5')
        });
        $("#button6").click(function(){
            ga('send', 'event', 'button', 'click', 'button6');
        }).mouseover(function () {
            ga('send', 'event', 'button', 'over', 'button6')
        });
    });
</script>
</body>
</html>