Listen wird nicht zu 100% abgefragt - nur Teile solle man lernen
Definitionen (was ist Requirementsengineering) nicht gefragt

Praktischer Teil
----------------

* kontrollflussgraphen
* testbereich
* UML
* Entscheidungsbäume

Einführung
----------

* Fakten sind nicht so wichtig
* Gefühl für Größenordnungen bei Software
* prominente Beispiele für schiefgegangene SW Projekte - ein Beispiel ist
  völlig in Ordnung
* Arten von Software
* Eigenschaften von Software

Kommunikation
-------------

* Friedemann Schulz von Thun
* Kommunikationsprobleme
* Beispiele
* Killerphrasen
* Schichtenmodell zur Bearbeitung von Konflikten
* NICHT: Kommunikationstypen - Handlungstopologien 
* Konflikt-Escalationsmodell und Schichtenmodell

Software Qualität
-----------------

* Qualitätsmerkmale
* Software Fehler
    - Arten von Fehlern mit Beispielen
    - Fehlerbewertung
* Konstruktive Qualitätssicherung
    - Richtlinien
        * Arten von Richtlinien (Notationen, Sprachrichtlinien mit
        Beispielen)
        * Bsp welche Vorteile oder Nachteile ergeben sich bei Einhaltung
        der Richtlinien oder Nichteinhaltung
        * NICHT: MISRA C 
    - Typisierung
        * In der Detailtiefe wie besprochen
        * Bsp in C oder in Java
    - Design by Contract
        * Prinzipien
        * NICHT: Implementierung
    - Fehlertolerante Programmierung
        * Möglichkeiten und ggfs. Beispiele
    - Dokumentation
        * Kenntnis der drei Varianten (informal, semiformal, formal) wobei
        formal nicht so wichtig ist
        * Codedokumentation - sinnvolle Codedoku?
        * Zusammenhänge
        * Für weiteres relevant: informal und formal
        * ggfs. Anwendung der besprochenen Methoden (Activity, Usecase,
        Klassen, Diagramm, Probleme bei informellen Spezifikation)
        * Prinzipien und Vorteile der Dok Generation
        * NICHT: Syntax und Anwendung der javadoc
    - Tests
        * gesamtes Kapitel relevant für Theorie und Praxis
        * Ursache-Wirkungsdiagramm nicht praktisch
        * Paarweises Testen praktisch
        * NICHT: Kontrollflusorientierte Strukturtests und Datenflussorientierte
        Strukturtests 
        * NICHT: Details zu gcov, hier nur Prinzip und was wird gemessen
        * Überdeckungen anwenden können. NICHT: Varianten der
        Bedingungsüberdeckung
        * Testmetriken - easy
        * NICHT: Mutationstests
    - Statische Analyse
        * Alles relevant
        * NICHT: Details der Reviearten (Walkthrough etc)
        * NICHT:  Liste aller Halstead Metriken, sondern: Eingabeparameter
        zur Berechnung, Prinzip, Kritikpunkte
        * McCabe Metrik - Wert für Metrik berechnen können, Definition,
        Interpretation

Vorgehensmodelle
----------------

* Wasserfall
* V-Modell
* Scrum im Detail
* NICHT: Sprialmodell, RUP

Vertragsmodelle
---------------

* Prinzipien

Aufwandsschätzungen
-------------------

* Von Cocomo und Function Point die Prinzipien, nicht die Details

Agiler Festpreis
----------------

* Warum Agiler Festpreis
* Wie komme ich dazu
* Bsp Absicherung für AG und AN: Ausstiegspunkte

RE
--

* Haupttätigkeiten
* NICHT: Nötige Fähigkeiten des REngineers auswendig lernen
* NICHT: Zahlen zur Bedeutung des RE
* NICHT: DEF von RE oder Anforderungen
* Qualitätsmerkmale nach ISO/IEC 9126-1: z. B. 4 aus 6
* Systemkontext - was ist das? Wie wird das dokumentiert?
* Quellen für Anforderungen
* Stakeholder Vereinbarung: Prinzip, NICHT die Listen der Pflichten und
Rechte auswendig lernen
* Stakeholder Liste
* NICHT: Stakeholder Portfolio
* NICHT: mündlich vermittelte Details zu den Ermittelungstechniken, aber
die Prinzipien
* NICHT: spezifische Dokumentstrukturen (z. B. Volere)
* Dokumentation natürlichsprachlich/modellbasiert
* Sprachliche effekte
* Satzschablone im Prinzip - Schablone nicht auswendig lernen
* Zielbäume
* Prinzipien der Prüfung von Anforderungen - 4 aus 6, die einzelnen
Prinzipien erklären können 
* Anforderungen verwalten - was steckt dahinter?
* Attribute für Anforderungen - welche sind besonders wichtig?

Konfig Management
-----------------

* was ist das?
* Grundsätzliche Aktivitäten
* Konfig Elemente - NICHT: die Liste auswendig lernen, Prinzipien
verstehen
* Rest komplett wichtig

Toolunterstützung Konfig Management
-----------------------------------

* SVN:
    - Prinzipien
        * zentral
        * Architektur
        * lokaler Arbeitsbereich
        * gemischte Revisionen
        * grundsätzliche Aktivitäten
        * unterstützte Protokolle
        * Prinzip bei tagging, branching und merging
    - Maven:
        * Probleme, die mit maven adressiert werden
        * Hauptfunktionalität
        * Prinzipien von maven
        * Architektur von maven
        * Repository manager
    - CI allgemein
        * Bestpractices nach Fowler: 6 aus 11
    - Hudson
        * Nutzen/Motivation
        * Funktionalität
        * Architektur
    - Redmine
        * ???

Architektur und Design
----------------------
???
