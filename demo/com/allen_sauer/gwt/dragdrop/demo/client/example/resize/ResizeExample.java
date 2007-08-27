/*
 * Copyright 2007 Fred Sauer
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.allen_sauer.gwt.dragdrop.demo.client.example.resize;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;

import com.allen_sauer.gwt.dragdrop.demo.client.DemoDragHandler;
import com.allen_sauer.gwt.dragdrop.demo.client.example.Example;

/**
 * Demonstrate the ability to capture
 * {@link com.allen_sauer.gwt.dragdrop.client.DragStartEvent DragStartEvents}
 * and {@link com.allen_sauer.gwt.dragdrop.client.DragEndEvent DragEndEvents}.
 */
public final class ResizeExample extends Example {

  private static final String CSS_DEMO_RESIZE_EXAMPLE = "demo-ResizeExample";
  private ResizeDragController resizeDragController;

  public ResizeExample(DemoDragHandler demoDragHandler) {
    addStyleName(CSS_DEMO_RESIZE_EXAMPLE);
    final AbsolutePanel boundaryPanel = new AbsolutePanel();
    boundaryPanel.setPixelSize(500, 200);

    resizeDragController = new ResizeDragController(boundaryPanel);
    resizeDragController.addDragHandler(demoDragHandler);

    final ResizePanel resizePanel = new ResizePanel(resizeDragController, getLargeHTML());
    boundaryPanel.add(resizePanel, 50, 30);
    setWidget(boundaryPanel);
  }

  public String getDescription() {
    return "Resize an embedded Widget using a composite of Grid and ScrollPanel.";
  }

  public Class[] getInvolvedClasses() {
    return new Class[] {ResizeExample.class, ResizeDropController.class, ResizeDragController.class, ResizePanel.class,};
  }

  private HTML getLargeHTML() {
    String t = "You can resize this panel by any of the four edges or corners.<br>";
    for (int i = 0; i < 3; i++) {
      t += "<br>The quick brown fox jumped over the lazy dog.";
    }
    HTML html = new HTML(t);
    html.addStyleName("demo-resize-html");
    return html;
  }
}
