/*
 * Copyright 2010-2019 Australian Signals Directorate
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package au.gov.asd.tac.constellation.views.find.advanced;

import au.gov.asd.tac.constellation.graph.Graph;
import au.gov.asd.tac.constellation.graph.WritableGraph;
import au.gov.asd.tac.constellation.pluginframework.PluginGraphs;
import au.gov.asd.tac.constellation.pluginframework.PluginInfo;
import au.gov.asd.tac.constellation.pluginframework.PluginInteraction;
import au.gov.asd.tac.constellation.pluginframework.PluginType;
import au.gov.asd.tac.constellation.pluginframework.parameters.PluginParameters;
import au.gov.asd.tac.constellation.pluginframework.templates.SimpleEditPlugin;
import au.gov.asd.tac.constellation.pluginframework.templates.SimplePlugin;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.NbBundle.Messages;

/**
 * This class provides access to the Graph Selection method, which is used by
 * the Find classes to display the identified results to the end user.
 *
 * @author betelgeuse
 * @see SimpleEditPlugin
 */
@PluginInfo(pluginType = PluginType.SELECTION, tags = {"SELECTION"})
@Messages("SelectFindResultsPlugin=Find: Update Selection")
public class SelectFindResultsPlugin extends SimplePlugin {

    private final List<FindResult> results;
    private final boolean isHeld;

    /**
     * Constructs a new <code>SelectFindResultsPlugin</code>, and passes in the
     * list * of results to be selected on the graph.
     *
     * @param results The list of vertices, transactions, edges or links that
     * were found in a find operation.
     * @param isHeld <code>Boolean</code> that sets the plugin to overwrite
     * current selection. <code>true</code> to 'hold' the current selection (ie,
     * not overwrite), <code>false</code> to clear selection.
     *
     * @see ArrayList
     * @see FindResult
     */
    public SelectFindResultsPlugin(final List<FindResult> results, final boolean isHeld) {
        this.results = results;
        this.isHeld = isHeld;
    }

    @Override
    protected void execute(final PluginGraphs graphs, final PluginInteraction interaction, final PluginParameters parameters)
            throws InterruptedException {
        Graph graph = graphs.getGraph();
        WritableGraph wg = graphs.getGraph().getWritableGraph(getName(), true);
        try {
            final QueryServices qs = new QueryServices(graph);
            QueryServices.selectOnGraph(wg, results, isHeld);
        } finally {
            wg.commit();
        }
    }
}
