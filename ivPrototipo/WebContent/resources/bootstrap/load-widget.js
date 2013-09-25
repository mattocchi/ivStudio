$(document).ready(function() {
	// $('.datepicker').datepicker({
	// format : 'dd/mm/yyyy',
	// weekStart : 1
	// });

	var datepickers = $('.datepicker').datepicker({
		format : 'dd/mm/yyyy',
		weekStart : 1
	}).on('changeDate', function(ev) {
		$(this).datepicker('hide');
	});

	// $('.date').datepicker({
	// format : 'dd/mm/yyyy',
	// weekStart : 1
	// });

	// $('.wysihtml5').wysihtml5();

	// $('.combobox').combobox();

	//$(".select2").select2();
	$('.select2').each(function() {
		$(this).select2();
	});

//	$(".select2Multiple").select2({
//		multiple : true
//	});
	
	$('.select2Clear').each(function() {
		$(this).select2({
			 placeholder: "Seleziona",
			 allowClear: true
		});
	});	
	 
});


//all jQuery events are executed within the document ready function
$(document).ready(function() {

   $("input").bind("keydown", function(event) {
      // track enter key
      var keycode = (event.keyCode ? event.keyCode : (event.which ? event.which : event.charCode));
      if (keycode == 13) { // keycode for enter key
         // force the 'Enter Key' to implicitly click the Update button
         // document.getElementById('defaultActionButton').click();
         $(".defaultActionButton").click();    	  
         return false;
      } else  {
         return true;
      }
   }); // end of function

}); // end of document ready