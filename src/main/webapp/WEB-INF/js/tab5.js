function createFileUploadTab(){
	return {
	        title: 'XLS Upload',
	        itemId: 'uploadTab',
	        layout: 'fit',
	        loader: {
	            url: 'tab/xlsUpload',   // JSP that contains the upload form
	            scripts: true ,
				autoLoad: true          // execute <script> inside that JSP if needed
	        }
	    };
}