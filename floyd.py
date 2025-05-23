import networkx as nx

G = nx.DiGraph()

G.add_node("A")
G.add_node("B")
G.add_node("C")
G.add_node("D")
G.add_node("E")

G.add_edge("A", "B", weight=3)
G.add_edge("A", "D", weight=7)
G.add_edge("B", "C", weight=1)
G.add_edge("B", "E", weight=8)
G.add_edge("C", "D", weight=2)
G.add_edge("D", "E", weight=3)
G.add_edge("E", "A", weight=4)

distancias = nx.floyd_warshall(G, weight='weight')

print("Matriz de distancias más cortas:")
for origen in distancias:
    for destino in distancias[origen]:
        valor = distancias[origen][destino]
        if valor == float("inf"):
            print(origen + " a " + destino + ": infinito")
        else:
            print(origen + " a " + destino + ": " + str(valor))
    print("")

menor_excentricidad = float("inf")
centro = None

for nodo in distancias:
    maximo = 0
    for destino in distancias[nodo]:
        if distancias[nodo][destino] > maximo:
            maximo = distancias[nodo][destino]
    if maximo < menor_excentricidad:
        menor_excentricidad = maximo
        centro = nodo

print("El centro del grafo es: " + centro)
