# Proyecto final (Pokedex)

##### Este proyecto consistió en desarrollar una aplicación que pueda localizar e identificar un pokemon (de un total de 15 especies/clases) con la cámara del celular utilizando el sistema  YOLO (You Only Look Once) el cual detecta objetos en tiempo real.

## Búsqueda y recolección de datos
Para el desarrollo de la aplicación se seleccionaron 15 especies de Pokemon: Pikachu, Charmander, Lapras, Bulbasaur, Evee, Psyduck, Squirtle, Ditto, Growlithe, Blastoise, Snorlax, Mewtwo, Magneton, Gastly y Omanyte.

De cada una de estas 15 especies se recolectaron 100 imágenes las cuales se utilizaron en la fase del entrenamiento de la red neuronal. Para la busqueda y recolección de imágenes se utilizaron diversas técnicas como la búsqueda directa de imágenes en una base de datos como [Kaggle](https://www.kaggle.com/lantian773030/pokemonclassification), realizando un web scraper, o descargando las imágenes del buscador de manera manual. La búsqueda manual se realizó ya que la aplicación al utiliza la cámara del celular los pokemones que detectará serán modelos reales (como peluches, muñecos o juguetes) y no modelos animados o dibuos, por lo que se consideró adecuado agregar ese tipo de imagenes de modelos reales para el entrenamiento.

## Etiquetado de los datos
Para etiquetar los datos se instaló [PyQt5](https://www.riverbankcomputing.com/software/pyqt/download) y [lxml](https://lxml.de/installation.html). Posteriormente se abrió el programa [labelImg.py](https://github.com/tzutalin/labelImg#labelimg) y se etiquetaron las imágenes de manera manual con formato YOLO.

##### Dependencias


##### Algoritmo


##### Contribuidores
* [GustavoDLRA](https://github.com/GustavoDLRA)
* [hugoyervides](https://github.com/hugoyervides)
* Astrid
* [olefran](https://github.com/olefran)
* [Felipe Villaseñor](https://github.com/Felipev201)

##### Referencias
- [Google Images Download](https://github.com/Joeclinton1/google-images-download)
- [Bing Image Scraper](https://gist.github.com/stephenhouser/c5e2b921c3770ed47eb3b75efbc94799)
- [Pokemon Dataset](https://www.kaggle.com/thedagger/pokemon-generation-one)
- [AIGuysCode Yolov4 Training in Tensorflow-lite](https://github.com/theAIGuysCode/tensorflow-yolov4-tflite)
- [The AI Guy’s Object Detection with YoloV4 Playlist](https://www.youtube.com/watch?v=mmj3nxGT2YQ&list=PLKHYJbyeQ1a3tMm-Wm6YLRzfW1UmwdUIN&index=2)
- [Poke API](https://pokeapi.co/)
