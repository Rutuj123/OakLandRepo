Ext.onReady(function () {

 		    Ext.create('Ext.tab.Panel', {

 		        renderTo: Ext.getBody(),

 		        width: 1200,
 		        height: 700,

 		        items: [
				createTab1(),
				createTab2(),
				
				createEmployeeTab(),
				createTabDwr(),
				createFileUploadTab() 
				
			
 		        ]

 		    });

 		});