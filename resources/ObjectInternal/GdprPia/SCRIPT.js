(function(ui) {

    if (!ui) return;
    var app = ui.getAjax();
    Simplicite.UI.hooks.GdprPia = function(o, cbk) {
        try {
            // In the example hooks will be available on main instance only
            // object UI parameters = clone of the globals properties
            var p = o.locals.ui;
            // When object form is loaded in the container ctn
            p.form.onload = function(ctn, obj) {
         
            	var gravDispStr = obj.getFieldValue("simPIAdispGrav");
            	var vraiDispStr = obj.getFieldValue("simPIAdispVrai");
            	var gravAccesStr = obj.getFieldValue("simPIAaccesGrav");
            	var vraiAccesStr = obj.getFieldValue("simPIAaccesVrai");
            	var gravModifStr = obj.getFieldValue("simPIAmodifsGravite");
            	var vraiModifStr = obj.getFieldValue("simPIAmodifsVraisemblance");
            	
            	var gravDispVal = getEstim(gravDispStr);
            	var vraiDispVal = getEstim(vraiDispStr);
            	var gravAccesVal = getEstim(gravAccesStr);
            	var vraiAccesVal = getEstim(vraiAccesStr);
            	var gravModifVal = getEstim(gravModifStr);
            	var vraiModifVal = getEstim(vraiModifStr);
            	
            	
            	var disp = gravDispVal + vraiDispVal;
            	var acces = gravAccesVal + vraiAccesVal;
            	var modif = gravModifVal + vraiModifVal;
            	
                var options = {
                    type: 'radar',
                    labels:['Disparition', 'Accès', 'Modification'],
                    data: {
					    datasets: [{
					    	label:'Vraisemblance',
					        data: [vraiDispVal, vraiAccesVal, vraiModifVal],
					        backgroundColor: 'rgba(255, 99, 132, 0.5)'
					    },{
					    	label:'Gravité',
					    	backgroundColor: 'rgba(54, 162, 235, 0.5)',
					    	data: [gravDispVal, gravAccesVal, gravModifVal]
					    }],
					
					    // These labels appear in the legend and in the tooltips when hovering different arcs
					    labels: [
					        'Disparition',
					        'Acces',
					        'Modification'
					    ]
					},
					options: {
							legend: {
								position: 'bottom',
							},
                            scale: {
                                ticks: {
                                    beginAtZero: true,
                                    max: 5,
                                    stepSize: 1,
                                    callback: function(label, index, labels) {
                                        switch (label) {
                                            case 0:
                                                return '';
                                            case 1:
                                                return 'Négligeable';
                                            case 2:
                                                return 'Limitée';
                                            case 3:
                                                return 'Importante';
                                            case 4:
                                                return 'Maximale';
                                            case 5:
                                            	return '';
                                        }
                                    }
                                }
                            }
                        }
                };
               

                $ui.loadCharts(function() {
                    $('#carto_div').after('<div class="row"><div class="col-sm-6"><div id="chart-container"></div></div><div class="col-sm-6"><div id="pie-container"></div></div></div>');
                    $ui.charts.chart($("#chart-container"), options);
                });



            };
            
            getEstim = function(val){
				switch (val) {
                    case 'NEG':
                        return 1;
                    case 'LIM':
                        return 2;
                    case 'IMP':
                        return 3;
                    case 'MAX':
                        return 4;
                    default:
                        return 0;
                }
            };
	
        } catch (e) {
            // Thank you to isolate your scripts
            app.error("Error in Simplicite.UI.hooks.myObject: " + e.message);
        } finally {
            // Required callback when hooks are loaded
            cbk && cbk();
        }
    };
})(window.$ui);