$(document).ready(function() {
	console.log("javascript has loaded");
	
    var test = [{"card": "estate", "cost" : "1"},
                {"card": "duchy", "cost" : "2"},
                {"card": "province", "cost" : "3"}];

 $("#myForm").submit(function() {
     $.ajax({
         type: "POST",
         url: "/",
         data: JSON.stringify(test),
         dataType: "JSON",
         success:function(data) {
                 console.log(data);},
         failure: function (errMsg) {
         console.log(errMsg);
     }
     });
 });
});