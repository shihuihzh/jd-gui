/*
 * Copyright (c) 2008-2015 Emmanuel Dupuy
 * This program is made available under the terms of the GPLv3 License.
 */

package org.jd.gui.view

import javax.swing.ScrollPaneConstants
import java.awt.BorderLayout
import java.awt.Dimension

dialog(
        id:'openTypeDialog',
        owner:mainFrame,
        title:'Open Type',
        modal:false) {
    panel(border:emptyBorder(15)) {
        borderLayout()
        vbox(constraints:BorderLayout.NORTH) {
            hbox {
                label(text:'Select a type to open (* = any string, ? = any character, TZ = TimeZone):')
                hglue()
            }
            vstrut(10)
            textField(id:'openTypeEnterTextField', columns:30)
            vstrut(10)
            hbox {
                label(id:'openTypeMatchLabel', text:'Matching types:')
                hglue()
            }
            vstrut(10)
        }
        scrollPane(
                constraints:BorderLayout.CENTER,
                horizontalScrollBarPolicy:ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER,
                preferredSize:new Dimension(400, 150)) {
            list(id:'openTypeList')
        }
        vbox(constraints:BorderLayout.SOUTH) {
            vstrut(25)
            hbox {
                hglue()
                button(id:'openTypeOpenButton') {
                    action(id:'openTypeOpenAction', name:'Open', enabled:false)
                }
                hstrut(5)
                button {
                    action(id:'openTypeCancelAction', name:'Cancel', closure:{ openTypeDialog.visible = false })
                }
            }
        }
    }
}