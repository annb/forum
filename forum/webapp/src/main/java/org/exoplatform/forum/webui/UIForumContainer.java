/***************************************************************************
 * Copyright (C) 2003-2007 eXo Platform SAS.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see<http://www.gnu.org/licenses/>.
 ***************************************************************************/
package org.exoplatform.forum.webui;

import org.exoplatform.webui.config.annotation.ComponentConfig;
import org.exoplatform.webui.core.UIContainer;

@ComponentConfig(
    template = "app:/templates/forum/webui/UIForumContainer.gtmpl"
)
public class UIForumContainer extends UIContainer {
  public UIForumContainer() throws Exception {
    addChild(UIForumDescription.class, null, null);
    addChild(UITopicContainer.class, null, null);
    addChild(UITopicDetailContainer.class, null, null).setRendered(false);
    addChild(UIForumSummary.class, null, null);
  }

  public void setIsRenderChild(boolean isRender) {
    getChild(UITopicContainer.class).setRendered(isRender);
    getChild(UITopicDetailContainer.class).setRendered(!isRender);
    UIForumSummary forumSummary = getChild(UIForumSummary.class).setRendered(isRender);
    forumSummary.getChild(UIForumIconState.class).setRendered(((UIForumPortlet)getParent()).isShowIconsLegend());
  }
}
