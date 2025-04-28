/**
 * 
 */
console.log("Reply Module.....");

var replyService = (function(){
	
	function list(param, callback, error) {
		var no = param;
		
		$.getJSON("/boardreply/list/" + no + ".json", function(data){
			if(callback) {
				callback(data);
			}
		}).fail(function(xhr, status, err) {
			if(err) {
				error();
			}
		});
	}
	
	function displayTime(timeValue) {
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);
		var str = "";
		
		if (gap < (1000*60*60*24)) {
			var hh = dateObj.getHours();
			var min = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ':', (min > 9 ? '' : '0') + min, ':', (ss > 9 ? '' : '0') + ss].join('');
		}
		else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return [yy, '-', (mm > 9 ? '' : '0') + mm, '-', (dd > 9 ? '' : '0') + dd].join('');
		}
	}
	
	return {
		list: list,
		displayTime: displayTime
	};
})();