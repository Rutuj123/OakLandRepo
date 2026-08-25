
function createEmployeeTab() { 
	
    return {
        title: 'Tab 3',
        layout: 'fit',
        items: [{
            xtype: 'employeegrid'
        }]
    };
}
Ext.define('Demo.view.employee.EmployeeGrid', {
    extend: 'Ext.grid.Panel',
    xtype: 'employeegrid',

    title: 'Employees',
    width: '100%',
    height: 600,
    scrollable: true,

    store: {
        fields: [
            'id',
            'employeeCode',
            'employeeName',
            'userType',
            'phone',
            'department',
            'status',
            'joiningDate',
            'createdDate',
            'updatedDate'
        ],
        pageSize: 15,
        remoteSort: true,
        remoteFilter: true,
        proxy: {
            type: 'ajax',
            url: 'employees/list',
            reader: {
                type: 'json',
                rootProperty: 'employees',
                totalProperty: 'totalRecords'
            },
            simpleSortMode: true,
            extraParams: {}
        },
        autoLoad: true
    },

    columns: [
        {
            text: '',
            dataIndex: 'id',
            width: 110,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'ID',
                width: 80,
				triggers: {
				       search: {
				           cls: 'x-form-search-trigger',
				           handler: function () {
				               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
				           }
				       }
				   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'employeeCode',
            flex: 1,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'Employee Code',
				width: 130,
				triggers: {
								       search: {
								           cls: 'x-form-search-trigger',
								           handler: function () {
								               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
								           }
								       }
								   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'employeeName',
            flex: 1.5,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'Employee Name',
				width: 140,
				triggers: {
												       search: {
												           cls: 'x-form-search-trigger',
												           handler: function () {
												               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
												           }
												       }
												   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'userType',
            flex: 1,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'User Type',
				triggers: {
																       search: {
																           cls: 'x-form-search-trigger',
																           handler: function () {
																               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
																           }
																       }
																   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'phone',
            flex: 1,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'Phone',
				triggers: {
																       search: {
																           cls: 'x-form-search-trigger',
																           handler: function () {
																               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
																           }
																       }
																   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'department',
            flex: 1,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'Department',
				triggers: {
																       search: {
																           cls: 'x-form-search-trigger',
																           handler: function () {
																               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
																           }
																       }
																   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '',
            dataIndex: 'status',
            flex: 1,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'Status',
				triggers: { search: { cls: 'x-form-search-trigger',  handler: function () {
																               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
																           }
																       }
																   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            }
        },
        {
            text: '', //Joining Date
            dataIndex: 'joiningDate',
            width: 140,
            menuDisabled: true,
            sortable: true,
            items: {
                xtype: 'textfield',
                emptyText: 'YYYY-MM-DD',
                width: 120,
				triggers: { search: {cls: 'x-form-search-trigger', handler: function () {
																               Demo.util.EmployeeSearch.reloadGrid(this.up('grid'));
																           }
																       }
																   },
                listeners: {
                    change: function(field) {
                        Demo.util.EmployeeSearch.reloadGrid(field.up('grid'));
                    }
                }
            },
            renderer: Ext.util.Format.dateRenderer('Y-m-d')
        }
    ],

    bbar: {
        xtype: 'pagingtoolbar',
        displayInfo: true
    },

    listeners: {
        afterrender: function(grid) {
            grid.down('pagingtoolbar').setStore(grid.getStore());
        }
    }
});

Ext.define('Demo.util.EmployeeSearch', {
    singleton: true,

    reloadGrid: function(grid) {
        var proxy = grid.getStore().getProxy();

        proxy.setExtraParams({
            employeeCode: grid.down('[dataIndex=employeeCode]').down('textfield').getValue(),
            employeeName: grid.down('[dataIndex=employeeName]').down('textfield').getValue(),
            userType: grid.down('[dataIndex=userType]').down('textfield').getValue(),
            phone: grid.down('[dataIndex=phone]').down('textfield').getValue(),
            department: grid.down('[dataIndex=department]').down('textfield').getValue(),
            status: grid.down('[dataIndex=status]').down('textfield').getValue(),
            joiningDate: grid.down('[dataIndex=joiningDate]').down('textfield').getValue()
        });

        grid.getStore().loadPage(1);
    }
});