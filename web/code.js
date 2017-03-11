$(function(){ // on dom ready


    $.getJSON( "nodes.json", function( nodes ) {
        $.getJSON( "edges.json", function( edges ) {
            $.getJSON( "solution.json", function( solution ) {
                $.getJSON( "search_path.json", function( searchPath ) {

                    console.log(nodes);
                    console.log(edges);
                    var cy = window.cy = cytoscape({
                        container: document.getElementById('cy'),

                        boxSelectionEnabled: false,
                        autounselectify: true,


                        style: [{"selector":"node","style":{ "content":"data(content)","font-size":"20px", "text-valign":"center","text-halign":"center","background-color":"#ddd", "opacity": "0.75", "color":"#000","overlay-padding":"6px","z-index":"10"}}, {"selector": ".highlighted", "style": {"background-color":"#212121", "opacity": "1"} }, {"selector": ".search", "style":{"background-color": "#009688"}}],


                        elements: {
                            nodes: nodes,
                            edges: edges
                        },

                        layout: {
                            name: 'dagre',
                            directed: true,
                            roots: '#a',
                            padding: 10
                        }
                    });

                    solution.forEach(function(e, i){
                        cy.getElementById(e).addClass("highlighted");
                    });

                    var i = 0;
                    var highlightNextEle = function(){
                        if( i < searchPath.length ){
                            cy.getElementById(searchPath[i]).addClass('search');

                            i++;
                            setTimeout(highlightNextEle, 1000);
                        }
                    };

        // kick off first highlight
                    highlightNextEle();


                });
            });
        });

    });



}); // on dom ready