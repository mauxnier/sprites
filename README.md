# Sprites

The Sprites project is composed of Java FX and Android applications: 

* a movie player: a movie is composed of successive sequences; a sequence is composed of a background and several overlapped mobile sprites. The movie is described using a JSON format. 

* a platform game: a game is composed of levels; a level is composed of a background and several sprites of different types. The player is represented by a mobile sprite. The game is described using a JSON format.

This version is a preliminary version that provides only classes and interfaces to load/save Zip files that contain JSON objects descriptions and other resource files (text files)

## Team

- Martin Bazire <bazire.e1905621@etud.univ-ubs.fr>
- Raphaël Heurlin <heurlin.e2105233@etud.univ-ubs.fr>
- Killian Monnier <monnier.e2103743@etud.univ-ubs.fr>
- Ikrame Bakkari <bakkari.e2104594@etud.univ-ubs.fr>
- Matisse Pedron <pedron.e1901069@etud.univ-ubs.fr>

## TODO
### 1. Project initialization
- [x] Project initialization.
### 2. Project architecture
- [x] all together: extend the ZipLoader to be able to manage image files (define the Image and ImageLoader interfaces).
- [x] one team: load/save images and display them on a canvas in a JavaFX application.
- [x] another team: write the whole JavaFX application: the interface components and the actions described above (you can use the MVC application given as an example).
### 3. Project model
- [x] refactor the previous *Loader interfaces and classes in order to generalize them by using genericity (some interfaces may be removed).
- [x] in the util subproject, update the Image interface and add the JsonConverter, SnapshotLayer and Snapshot interfaces.
- [x] implements the SnapshotLayer and Snapshot interfaces. Warning: the provided tests, in order to compare objects, use the equals method. This method should be redefined in some classes in order to compare the objects values (rather than their identities).
- [ ] implement converters for the SnapshotLayer and Snapshot types.
- [ ] inspect the given interfaces in the sprites.model subproject. Implement the Sprite interface and implement a converter for the Sprite type.
- [x] add a unit test for the converter for the Sprite type.
- [ ] upgrade the JavaFX application in order to load and display a snapshot when a json file starting with "snapshot" is selected.
### 4. Android application
- [ ] This application will provide a button to open a ZIP file in the application raw resources, load this file and, if a JSON file starting with "snapshot" is found, display the snapshot on the app view.
### 5. Movie display
#### Application model
- [ ] Implement two types of SpriteActions (motion and visibility actions), and a single associated JsonConverter. The actions properties can be deduced from the JSON schema of an action described in the sequence-schema.json file.
- [ ] Implement the other interfaces of the model (Scene, Sequence, Movie) and the associated JsonConverters.
- [ ] Implement a factory class that provides the appropriate JsonConverter instance from a JSON file name and/or a given type.
#### Code refactoring: factorization
- [ ] Add the fr.ensibs.util.graphic.Graphic interface to your project from this GitLab project. This interface represents a generic graphic system to draw images and snapshots.
- [ ] Using the code already made in order to display images and snapshots in the JavaFX and Android applications, implement a Graphic class for each system (JavaFX and Android). For each implementation, you should define which object (delegate) is required and pass it to the constructor.
- [ ] Factorize the common functionalities developped in the JavaFX and Android applications in a common class in order to avoid code redondency.
#### Engines
- [ ] Add the fr.ensibs.util.sync.Scheduler interface and the fr.ensibs.util.sync.SchedulerImpl implementation to your project from this GitLab project.
- [ ] Develop two other implementations of the fr.ensibs.util.sync.Scheduler interface for the Android and JavaFX projects that allow to run periodic tasks in the graphic threads for each system.
- [ ] Develop graphic and model engines that run periodically a task;