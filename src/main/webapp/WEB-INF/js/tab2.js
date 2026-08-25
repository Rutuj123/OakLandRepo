function createTab2() {

		    return {

		        title: 'Tab 2',

		        xtype: 'panel',

		        bodyPadding: 20,

		        items: [

		            {
		                xtype: 'button',

		                text: 'Open Editor',

		                handler: function () {

		                    Ext.create('Ext.window.Window', {

								title: 'Patient Details',

								        width: 900,

								        height: 600,

								        modal: true,

								        layout: 'anchor',

								        bodyPadding: 15,

								        items: [

								            
								            {
								                xtype: 'fieldset',

								                title: 'Patient Details',

								                anchor: '100%',

								                layout: 'column',

								                defaults: {
								                    xtype: 'displayfield',
								                    labelWidth: 120,
								                    width: 380
								                },

								                items: [

								                    {
								                        fieldLabel: 'Name',
								                        value: 'CT SCAN'
								                    },

								                    {
								                        fieldLabel: 'MRN',
								                        value: 'CYTOLOGY'
								                    },

								                    {
								                        fieldLabel: 'Date Of Birth',
								                        value: 'DIGITAL X-RAY'
								                    },

								                    {
								                        fieldLabel: 'Age',
								                        value: 'FLUID EXAMINATION'
								                    },

								                    {
								                        fieldLabel: 'Gender',
								                        value: 'GASTROENTEROLOGY INVESTIGATION'
								                    },

								                    {
								                        fieldLabel: 'Address',
								                        value: 'HAEMATOLOGY'
								                    },

								                    {
								                        fieldLabel: 'Reg Date',
								                        value: 'HARMONES'
								                    },

								                    {
								                        fieldLabel: 'Status',
								                        value: 'HISTOPATHOLOGY'
								                    }

								                ]
								            },

								            {
								                xtype: 'component',
								                height: 15
								            },

								            // =========================
								            // HTML Editor
								            // =========================
								            {
								                xtype: 'htmleditor',

								                fieldLabel: 'Text Editor',

								                labelAlign: 'top',

								                anchor: '100%',

								                height: 220,

								                value: 'CT SCAN, CYTOLOGY, DIGITAL X-RAY, FLUID EXAMINATION, GASTROENTEROLOGY INVESTIGATION, HAEMATOLOGY, HARMONES, HISTOPATHOLOGY'
								            }

								        ],

								        buttons: [

								            {
								                text: 'Close',

								                handler: function (btn) {

								                    btn.up('window').close();

								                }
								            }

								        ]

								    }).show();

		                }
		            }

		        ]
		    };
		}