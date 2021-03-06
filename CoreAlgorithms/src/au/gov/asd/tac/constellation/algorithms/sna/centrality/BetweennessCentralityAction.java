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
package au.gov.asd.tac.constellation.algorithms.sna.centrality;

import au.gov.asd.tac.constellation.algorithms.AlgorithmPluginRegistry;
import au.gov.asd.tac.constellation.graph.node.GraphNode;
import au.gov.asd.tac.constellation.pluginframework.PluginExecution;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;

/**
 * Betweenness centrality action.
 *
 * @author cygnus_x-1
 */
@ActionID(category = "Centrality", id = "au.gov.asd.tac.constellation.algorithms.sna.centrality.BetweennessCentralityAction")
@ActionRegistration(displayName = "#CTL_BetweennessCentralityAction")
@NbBundle.Messages("CTL_BetweennessCentralityAction=Betweenness Centrality")
public class BetweennessCentralityAction implements ActionListener {

    private final GraphNode context;

    public BetweennessCentralityAction(final GraphNode context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(final ActionEvent event) {
        PluginExecution.withPlugin(AlgorithmPluginRegistry.BETWEENNESS_CENTRALITY)
                .withParameter(BetweennessCentralityPlugin.INCLUDE_CONNECTIONS_IN_PARAMETER_ID, false)
                .withParameter(BetweennessCentralityPlugin.INCLUDE_CONNECTIONS_OUT_PARAMETER_ID, true)
                .withParameter(BetweennessCentralityPlugin.TREAT_UNDIRECTED_BIDIRECTIONAL, true)
                .withParameter(BetweennessCentralityPlugin.NORMALISE_POSSIBLE_PARAMETER_ID, true)
                .withParameter(BetweennessCentralityPlugin.NORMALISE_AVAILABLE_PARAMETER_ID, false)
                .withParameter(BetweennessCentralityPlugin.NORMALISE_CONNECTED_COMPONENTS_PARAMETER_ID, false)
                .withParameter(BetweennessCentralityPlugin.SELECTED_ONLY_PARAMETER_ID, false)
                .executeLater(context.getGraph());
    }
}
