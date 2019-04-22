Hinweise zu FXML:

Die .fxml-Files beschreiben den grundsätzlichen Aufbau der Scene (also das, was angezeigt wird), ähnlich wie bei HTML.
Da die CSS-Unterstützung bei JavaFX leider nur in Teilen vorhanden ist, müssen einige Attribute direkt in der Deklarierung
der Elemente im .fxml-File gesetzt werden.
Grundsätzlich gilt: Eine aus einem .fxml-File erzeugte Scene besteht auf unterster Ebene IMMER aus EINEM Container, ich habe
meistens ein GridPane verwendet (Vor- und Nachteile bzw. Eigenschafter der einzelnen Container lassen sich im Internet nachlesen
oder im Scene Builder ausprobieren).
Was nicht im CSS-File deklariert werden kann, ist zum einen der Text (z.B. bei Button, Combo-Boxen, etc.) und die Anordung der
einzelnen Elemente im übergeordneten Container. Das GridPane ist zum Beispiel wie eine Tabelle aufgebaut, d.h., dass alle Elemente,
die sich darin befinden, einen festen Platz haben müssen, also z.B. "Reihe 3, Spalte 2". Die Größe der einzelnen Zeilen und Spalten
müssen meines Wissens leider auch im .fxml-File deklariert werden. Das genaue Vorgehen sollte beim Ansehen der bereits vorhandenen
Dateien klar werden.
Dem alles umfassenden Container sollte ein "fx:controller" hinzugefügt werden. Dieser wird beim Aufruf der Scene, die auf dem
.fxml-File basiert, initialisiert, d.h., man kann einen Konstruktor definieren. Da die restlichen Elemente zum Zeitpunkt des
Konstruktor-Aufrufs allerdings noch nicht erzeugt wurden, muss für deren Verwendung die "initialize"-Methode verwendet werden,
die nach dem Aufbau der Scene automatisch aufgerufen wird.
Falls ein Element programmatisch relevant ist (z.B. wenn man den Inhalt eines TextFields auslesen will) muss man dem Element eine
"fx:id" (z.B. fx:id="textfield") zuweisen. Im Controller kann man dann eine lokale Variable mit dem gleichen Typ und dem gleichen
Namen deklarieren (im Beispiel also @FXML private TextField textfield;), um das Element verwenden zu können.
Bei nteraktiven Elemente (Buttons, CheckBoxes, ComboBoxes, etc.) kann zusätzlich noch im .fxml-File festgelegt werden, was bei
der Interaktion passiert (mit dem Parameter onAction). Hier muss dann der Name der Methode stehen, die im Controller geschrieben
wurde (auch mit "@FXML" davor), z.B.:
im .fxml-File: "<button onAction="#action""/>"
im Controller: @FXML private void action() {...}



Hinweis zur JavaFX-Einbindung:

Eigentlich sollte das Projekt, bzw. die Main, direkt nach Importieren des Projekts ausführbar sein. Sollten die verwendeten JavaFX-
Packages nicht gefunden werden, müsst ihr die JavaFX-Library im Projekt als externe Library einbinden, das sollte aber eigentlich
nicht nötig sein, da die Library im Projektordner enthalten ist und der Verweis darauf funktionieren sollte.



Hinweise zu den VM-Options:

Nach dem Importieren ist das Projekt nicht ausführbar. Das liegt daran, dass die verwendeten .jar-Files aus der JavaFX-Library nicht
automatisch in die JRE geladen werden, deshalb muss die Run-Config verändert werden. In IntelliJ ist dafür neben dem "Run"-Button
ein Dropdown-Menü, in dem ihr dann auf "Edit Configurations" drücken müsst. Hier müsst ihr dann bei "VM-Options" folgendes einfügen:
--module-path "external libs\javafx-sdk-12\lib" --add-modules javafx.controls,javafx.fxml
In Eclipse weiß ich leider nicht, wie das geht, die VM-Options sollten aber die gleichen sein.
