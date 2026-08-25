function createTab1() {

    return {
        title: 'Tab 1',
        xtype: 'panel',
        bodyPadding: 20,

        items: [

            {
                xtype: 'container',
                layout: 'hbox',

                items: [

                    {
                        xtype: 'combo',
                        emptyText: 'Department',
                        width: 220,
                        margin: '0 15 0 0',

                        editable: false,

                        queryMode: 'local',

                        store: [
                            'NURSING',
                            'RADIATION ONCOLOGY',
                            'ULTRASOUND'
                        ]
                    },

                    {
                        xtype: 'combo',
                        emptyText: 'STATIC VALUE',
                        width: 220,

                        editable: false,

                        queryMode: 'local',

                        store: [
                            'NURSING',
                            'ULTRASOUND',
                            'RADIATION ONCOLOGY'
                        ]
                    }

                ]
            }

        ]
    };
}