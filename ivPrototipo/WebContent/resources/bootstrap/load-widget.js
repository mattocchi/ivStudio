jQuery(document).ready(function() {
	// $('.datepicker').datepicker({
	// format : 'dd/mm/yyyy',
	// weekStart : 1
	// });

	var datepickers = jQuery('.datepicker').datepicker({
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

	jQuery(".select2").select2();

	jQuery(".select2Multiple").select2({
		multiple : true
	});

});