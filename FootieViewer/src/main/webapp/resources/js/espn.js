$(document).ready(function() {
	$('#playerinput').val('');
	$('#playerinput').focus();

});

function openUrl(url) {
	window.location = url;
	return false;
}

function playerSearch(e, q) {
	var searchString = escape(q);
	var $tbl = $('div#results table');
	$('tr:gt(0)', $tbl).remove(); // remove any old results
	if (q.length < 2) {
		return;
	}
	$.getJSON("getPlayers?playerName=" + searchString, {}, function(response) {
		for ( var i in response) {
			$tbl.append("<tr class='player' onclick=modal('"
					+ response[i].espnUrl + "')><td>"
					+ response[i].firstName + "</td><td>"
					+ response[i].lastName + "</td></tr>");
		}
	});

}

function modal(url) {
	$('<div></div>').html(
			'<iframe class="modal" style="border: 0px; " sandbox="allow-forms allow-scripts" src=" ' + url
					+ '" width="100%" height="100%"></iframe>').modal();
}
