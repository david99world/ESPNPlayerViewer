<!DOCTYPE html>
<html>
<head>
<title>Player Viewer</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/espn.css">
<link rel="stylesheet" href="css/bootstrap-responsive.css">
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
</head>
<body>
	<div id="header" style="clear: both;">
		<img src="img/logo.png" style="float: left;" />
		<img src="img/type.png" style="float: right;" />
		<div>
			<input type="text" id="playerinput"
				onKeyUp="playerSearch(event, this.value);" tabindex='2' value="" />
		</div>
	</div>
	<div id="results">
		<table class="table table-hover table-striped table-condensed">
			<tr>
				<th style="width: 40%">First name</th>
				<th style="width: 40%">Last name</th>
			</tr>
		</table>
	</div>
</body>
<script type="text/javascript" src="js/espn.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-40849756-2']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</html>
