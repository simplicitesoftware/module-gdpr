<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

`SimGdpr` module definition
===========================

Simplicite GDPR Module

`GdprActor` business object definition
--------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|

`GdprActorPac` business object definition
-----------------------------------------

N-N between Pac and Actor

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprActorPacPacId` link to **`GdprProcessingActivity`**     | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `gdprActorPacPacId.gdprPacId`_                         | _int(11)_                                |          |           |          | -                                                                                |
| _Ref. `gdprActorPacPacId.gdprPacName`_                       | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| `gdprActorPacActorId` link to **`GdprActor`**                | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `gdprActorPacActorId.usr_login`_                       | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `gdprActorPacActorId.usr_last_name`_                   | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `gdprActorPacActorId.usr_first_name`_                  | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| `gdprActorType`                                              | enum(20) using `GDPRACTORTYPE` list      |          | yes       |          | -                                                                                |

### Lists

* `GDPRACTORTYPE`
    - `RESP` Responsible for treatment
    - `DPO` Data Protection Officer
    - `REP` Representation
    - `CONJ` Joint Manager

`GdprEntEnt` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprEntEntElementId` link to **`GdprEntity`**               | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprEntEntElementId.gdprEntName`_                     | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `gdprEntEntElementId.gdprEntLegalName`_                | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `gdprEntEntElementId.gdprEntDescription`_              | _html(1000000)_                          |          |           |          | -                                                                                |
| `gdprEntEntEnclosingId` link to **`GdprEntity`**             | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprEntEntEnclosingId.gdprEntName`_                   | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `gdprEntEntEnclosingId.gdprEntLegalName`_              | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `gdprEntEntEnclosingId.gdprEntDescription`_            | _html(1000000)_                          |          |           |          | -                                                                                |

`GdprEntity` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprEntName`                                                | char(100)                                | *        | yes       |          | -                                                                                |
| `gdprEntityProcessingActivityFk` link to **`GdprProcessingActivity`** | id                                       |          | yes       |          | -                                                                                |
| `gdprEntLegalName`                                           | char(100)                                |          | yes       |          | -                                                                                |
| `gdprEntLogo`                                                | image                                    |          | yes       |          | Entity's logo                                                                    |
| `gdprEntDescription`                                         | html(1000000)                            |          | yes       |          | -                                                                                |

`GdprPacPvdApp` business object definition
------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPacPvdAppPacPvdId` link to **`GdprPacPvd`**             | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `gdprPacPvdAppPacPvdId.gdprPacPvdPacId`_               | _id_                                     |          |           |          | _Sub-Process_                                                                    |
| _Ref. `gdprPacPvdPacId.gdprPacName`_                         | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprPacPvdAppPacPvdId.gdprPacPvdPvdId`_               | _id_                                     |          |           |          | _Private Data_                                                                   |
| _Ref. `gdprPacPvdPvdId.gdprPvdName`_                         | _char(100)_                              |          |           |          | _Private data name_                                                              |
| _Ref. `gdprPacPvdAppPacPvdId.gdprPacPvdUid`_                 | _char(10)_                               |          |           |          | -                                                                                |
| _Ref. `gdprPacPvdPvdId.gdprPvdCat`_                          | _multi(50) using `GDPRPVDCAT` list_      |          |           |          | -                                                                                |
| `gdprPacPvdAppAppId` link to **`GdprApplication`**           | id                                       | yes*     | yes       |          | -                                                                                |
| _Ref. `gdprPacPvdAppAppId.gdprAppIdentifier`_                | _regexp(50)_                             |          |           |          | -                                                                                |
| _Ref. `gdprPacPvdAppAppId.gdprAppName`_                      | _char(100)_                              |          |           |          | -                                                                                |
| `gdprPacPvdEntType`                                          | enum(25) using `GDPRPACPVDENTTYPE` list  | yes*     | yes       |          | Type                                                                             |
| `gdprPacPvdEntChannel`                                       | enum(20) using `GDPRPACPVDENTCHANNEL` list |          | yes       |          | Channel                                                                          |

### Lists

* `GDPRPVDCAT`
    - `ID` Identification
    - `PERS` Personnal
    - `ECO` Economic
    - `LOGIN` Login
    - `LOCAL` Location
* `GDPRPACPVDENTTYPE`
    - `PROVIDING` Providing
    - `CONSUMING` Consuming
    - `PROCESSING` Processing
* `GDPRPACPVDENTCHANNEL`
    - `UI` User interface
    - `MANUAL` Manual
    - `WS` Webservices
    - `FTP` (S)FTP
    - `OTHER` Others

`GdprPersonConcerned` business object definition
------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPersonConcernedCategory`                                | enum(20) using `GDPRPERSONCONCERNEDCATEGORY` list | yes*     | yes       |          | Category of the person concerned                                                 |
| `gdprPersonConcernedDesc`                                    | html(1000000)                            |          | yes       |          | Description of the category of people concerned                                  |

### Lists

* `GDPRPERSONCONCERNEDCATEGORY`
    - `EMP` Employees
    - `CLI` Client
    - `PAT` Patient
    - `PRO` Prospect

`GdprPia` business object definition
------------------------------------

PIA Form

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPiaId`                                                  | char(12)                                 | yes*     |           |          | -                                                                                |
| `gdprPiaPrincMesuresEvalEnum`                                | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesMesuresEvalEnum`                              | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesModifsEvalEnum`                               | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesDispEvalEnum`                                 | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrinMesuresEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesMesuresEval`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesModifsEval`                                   | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesDispEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiAaccesEvalComment`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaName`                                                | char(150)                                | *        | yes       |          | Title of the PIA                                                                 |
| `gdprPiaSaisie`                                              | char(200)                                |          | yes       |          | Nom de la personne saisissant le PIA                                             |
| `gdprPiaEval`                                                | char(200)                                |          | yes       |          | Nom de l'évaluateur                                                              |
| `gdprPiaValidation`                                          | char(200)                                |          | yes       |          | Nom du validateur                                                                |
| `gdprPiaDateValidation`                                      | date                                     |          |           |          | Date de la validation                                                            |
| `gdprPiaState`                                               | enum(50) using `GDPRPIASTATE` list       |          | yes       |          | Etat du PIA                                                                      |
| `gdprPacPiaId` link to **`GdprProcessingActivity`**          | id                                       |          | yes       |          | -                                                                                |
| _Ref. `gdprPacPiaId.gdprPacId`_                              | _int(11)_                                |          |           |          | -                                                                                |
| _Ref. `gdprPacPiaId.gdprPacName`_                            | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprPacPiaId.gdprPacRef`_                             | _char(50)_                               |          |           |          | -                                                                                |
| `gdprPiaRespTrait`                                           | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaRefApp`                                              | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaConEnsembleEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaCycledonnee`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaSupportdonnee`                                       | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaDonneeEvaluation`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprFinaldeter`                                             | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaTraitementlicite`                                    | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaDonneesadequates`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDonneeAjour`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaConservationDonnee`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaInformee`                                            | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaConsentObtenu`                                       | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitAcces`                                          | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitRectification`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitLimitation`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaObligSousTrait`                                      | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaTransHorsUeProtegees`                                | text(100)                                |          | yes       |          | -                                                                                |
| `gdprPiaMesuresDonnee`                                       | multi(400) using `GDPRPIAMESURESSECURITE` list |          | yes       |          | -                                                                                |
| `gdprPiaMesuresSecuSys`                                      | multi(90) using `GDPRPIAMESURESSECUSYS` list |          | yes       |          | -                                                                                |
| `gdprPiaMesuresOrga`                                         | multi(500) using `GDPRPIAMESURESORGA` list |          | yes       |          | -                                                                                |
| `gdprPiaAccesImpact`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesMenace`                                         | multi(100) using `GDPRPIAACCESMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaAccesSources`                                        | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesMesures`                                        | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesGrav`                                           | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaAccesVrai`                                           | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaModifImpact`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaModifsMenace`                                        | multi(10000) using `GDPRPIAMODIFSMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaModifsSource`                                        | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaModifsMesures`                                       | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaModifsGravite`                                       | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaModifsVraisemblance`                                 | enum(10000) using `GDPRPIAESTIM` list    |          | yes       |          | -                                                                                |
| `gdprPiaDispImpact`                                          | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispMenaces`                                         | multi(100) using `GDPRPIADISPMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaDispSources`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispMesures`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispGrav`                                            | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaDispVrai`                                            | enum(10000) using `GDPRPIAESTIM` list    |          | yes       |          | -                                                                                |
| `gdprPiaRecapImpacts`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapMenaces`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapSources`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapMesures`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaAccesEvalEnum`                                       | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaConEnsembleEvalEnum`                                 | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaConDonneesEvalEnum`                                  | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrincPropEvalEnum`                                   | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrincPropEval`                                       | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaCartoGraph`                                          | char(200)                                |          |           |          | -                                                                                |

### Lists

* `GDPRPIAEVAL`
    - `COR` A corriger
    - `AM` Améliorable
    - `ACE` Acceptable
* `GDPRPIASTATE`
    - `CREA` Creation
    - `ENCOURS` In progress
    - `ENAVAL` En attente de validation
    - `NONVALID` Validation refused
    - `SIMPLVALID` Simple validation
    - `SIGNVALID` Signed validation
* `GDPRPIAMESURESSECURITE`
    - `CHIF` Chiffrement
    - `ANON` Anonymisation
    - `CONT` Contrôle des accès logiques
    - `JOUR` Journalisation
    - `ARCH` Archivage
    - `PAPI` Sécurisation des documents papier
    - `MINI` Minimisation des données
* `GDPRPIAMESURESSECUSYS`
    - `EXPLOIT` Sécurisation de l'exploitation
    - `MALV` Lutte contre les logiciels malveillants
    - `POST` Gestion des postes de travail
    - `SITE` Protection des sites web
    - `SAUV` Sauvegarde des données
    - `MAINT` Maintenance
    - `SOUS` Contrat de sous-traitance
    - `SECU` Sécurisation des canaux informatiques
    - `PHY` Sécurité physique
    - `TRAC` Traçabilité
    - `MATE` 
    - `ELOI` 
    - `PROT` 
* `GDPRPIAMESURESORGA`
    - `ORGA` Organisation de la politique de protection de la vie privée
    - `POLI` Gérer la politique de protection de la vie privée
    - `RISQ` Gérer les risques
    - `PRIV` Intégrer la protection de la vie privée dans les projets
    - `INCID` Gérer les incidents de sécurité et les violations de données
    - `PERS` Gestion des personnels
    - `TIERS` Gestion des tiers accédant aux données
    - `SUPER` Superviser la protection de la vie privée
* `GDPRPIAACCESMENACE`
    - `CIO` CIO
    - `CPO` CPO
    - `DPO` DPO
    - `DPP` DPP
    - `LM` LM
    - `LU` LU
    - `MM` MM
    - `MO` MO
    - `MP` MP
    - `MU` MU
    - `PD` PD
    - `PO` PO
    - `PP` PP
* `GDPRPIAESTIM`
    - `NEG` 
    - `LIM` 
    - `IMP` 
    - `MAX` 
* `GDPRPIAMODIFSMENACE`
    - `CIU` CIU
    - `CPM` CPM
    - `DPM` DPM
    - `LM` LM
    - `LU` LU
    - `MM` MM
    - `PD` PD
    - `PS` PS
* `GDPRPIADISPMENACE`
    - `CID` CID
    - `CIP` CIP
    - `CIS` CIS
    - `CPM` CPM
    - `CPP` CPP
    - `CPS` CPS
    - `DPP` DPP
    - `CPU` CPU
    - `LD` LD
    - `LM` LM
    - `LP` LP
    - `LS` LS
    - `LU` LU
    - `MD` MD
    - `MM` MM
    - `MP` MP
    - `MS` MS
    - `MU` MU
    - `PD` PD
    - `PP` PP
    - `PS` PS

`GdprPiaHistoric` business object definition
--------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `row_ref_id` link to **`GdprPia`**                           | id                                       | yes*     |           |          | Record row ID                                                                    |
| `row_idx`                                                    | int(11)                                  | yes*     | yes       |          | History record index                                                             |
| `created_by_hist`                                            | char(100)                                | yes*     |           |          | Created by                                                                       |
| `created_dt_hist`                                            | datetime                                 | yes*     |           |          | Created date                                                                     |
| `gdprPiaId`                                                  | char(12)                                 | yes*     |           |          | -                                                                                |
| `gdprPiaPrincMesuresEvalEnum`                                | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesMesuresEvalEnum`                              | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesModifsEvalEnum`                               | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaRisquesDispEvalEnum`                                 | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrinMesuresEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesMesuresEval`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesModifsEval`                                   | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaRisquesDispEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiAaccesEvalComment`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaName`                                                | char(150)                                | *        | yes       |          | Title of the PIA                                                                 |
| `gdprPiaSaisie`                                              | char(200)                                |          | yes       |          | Nom de la personne saisissant le PIA                                             |
| `gdprPiaEval`                                                | char(200)                                |          | yes       |          | Nom de l'évaluateur                                                              |
| `gdprPiaValidation`                                          | char(200)                                |          | yes       |          | Nom du validateur                                                                |
| `gdprPiaDateValidation`                                      | date                                     |          |           |          | Date de la validation                                                            |
| `gdprPiaState`                                               | enum(50) using `GDPRPIASTATE` list       |          | yes       |          | Etat du PIA                                                                      |
| `gdprPacPiaId` link to **`GdprProcessingActivity`**          | id                                       |          | yes       |          | -                                                                                |
| _Ref. `gdprPacPiaId.gdprPacId`_                              | _int(11)_                                |          |           |          | -                                                                                |
| _Ref. `gdprPacPiaId.gdprPacName`_                            | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprPacPiaId.gdprPacRef`_                             | _char(50)_                               |          |           |          | -                                                                                |
| `gdprPiaRespTrait`                                           | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaRefApp`                                              | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaConEnsembleEval`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaCycledonnee`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaSupportdonnee`                                       | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaDonneeEvaluation`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprFinaldeter`                                             | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaTraitementlicite`                                    | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaDonneesadequates`                                    | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDonneeAjour`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaConservationDonnee`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaInformee`                                            | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaConsentObtenu`                                       | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitAcces`                                          | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitRectification`                                  | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDroitLimitation`                                     | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaObligSousTrait`                                      | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaTransHorsUeProtegees`                                | text(100)                                |          | yes       |          | -                                                                                |
| `gdprPiaMesuresDonnee`                                       | multi(400) using `GDPRPIAMESURESSECURITE` list |          | yes       |          | -                                                                                |
| `gdprPiaMesuresSecuSys`                                      | multi(90) using `GDPRPIAMESURESSECUSYS` list |          | yes       |          | -                                                                                |
| `gdprPiaMesuresOrga`                                         | multi(500) using `GDPRPIAMESURESORGA` list |          | yes       |          | -                                                                                |
| `gdprPiaAccesImpact`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesMenace`                                         | multi(100) using `GDPRPIAACCESMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaAccesSources`                                        | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesMesures`                                        | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaAccesGrav`                                           | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaAccesVrai`                                           | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaModifImpact`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaModifsMenace`                                        | multi(10000) using `GDPRPIAMODIFSMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaModifsSource`                                        | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaModifsMesures`                                       | text(10000)                              |          | yes       |          | -                                                                                |
| `gdprPiaModifsGravite`                                       | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaModifsVraisemblance`                                 | enum(10000) using `GDPRPIAESTIM` list    |          | yes       |          | -                                                                                |
| `gdprPiaDispImpact`                                          | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispMenaces`                                         | multi(100) using `GDPRPIADISPMENACE` list |          | yes       |          | -                                                                                |
| `gdprPiaDispSources`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispMesures`                                         | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaDispGrav`                                            | enum(10) using `GDPRPIAESTIM` list       |          | yes       |          | -                                                                                |
| `gdprPiaDispVrai`                                            | enum(10000) using `GDPRPIAESTIM` list    |          | yes       |          | -                                                                                |
| `gdprPiaRecapImpacts`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapMenaces`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapSources`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaRecapMesures`                                        | text(3000)                               |          |           |          | -                                                                                |
| `gdprPiaAccesEvalEnum`                                       | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaConEnsembleEvalEnum`                                 | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaConDonneesEvalEnum`                                  | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrincPropEvalEnum`                                   | enum(10) using `GDPRPIAEVAL` list        |          | yes       |          | -                                                                                |
| `gdprPiaPrincPropEval`                                       | text(1000)                               |          | yes       |          | -                                                                                |
| `gdprPiaCartoGraph`                                          | char(200)                                |          |           |          | -                                                                                |

### Lists

* `GDPRPIAEVAL`
    - `COR` A corriger
    - `AM` Améliorable
    - `ACE` Acceptable
* `GDPRPIASTATE`
    - `CREA` Creation
    - `ENCOURS` In progress
    - `ENAVAL` En attente de validation
    - `NONVALID` Validation refused
    - `SIMPLVALID` Simple validation
    - `SIGNVALID` Signed validation
* `GDPRPIAMESURESSECURITE`
    - `CHIF` Chiffrement
    - `ANON` Anonymisation
    - `CONT` Contrôle des accès logiques
    - `JOUR` Journalisation
    - `ARCH` Archivage
    - `PAPI` Sécurisation des documents papier
    - `MINI` Minimisation des données
* `GDPRPIAMESURESSECUSYS`
    - `EXPLOIT` Sécurisation de l'exploitation
    - `MALV` Lutte contre les logiciels malveillants
    - `POST` Gestion des postes de travail
    - `SITE` Protection des sites web
    - `SAUV` Sauvegarde des données
    - `MAINT` Maintenance
    - `SOUS` Contrat de sous-traitance
    - `SECU` Sécurisation des canaux informatiques
    - `PHY` Sécurité physique
    - `TRAC` Traçabilité
    - `MATE` 
    - `ELOI` 
    - `PROT` 
* `GDPRPIAMESURESORGA`
    - `ORGA` Organisation de la politique de protection de la vie privée
    - `POLI` Gérer la politique de protection de la vie privée
    - `RISQ` Gérer les risques
    - `PRIV` Intégrer la protection de la vie privée dans les projets
    - `INCID` Gérer les incidents de sécurité et les violations de données
    - `PERS` Gestion des personnels
    - `TIERS` Gestion des tiers accédant aux données
    - `SUPER` Superviser la protection de la vie privée
* `GDPRPIAACCESMENACE`
    - `CIO` CIO
    - `CPO` CPO
    - `DPO` DPO
    - `DPP` DPP
    - `LM` LM
    - `LU` LU
    - `MM` MM
    - `MO` MO
    - `MP` MP
    - `MU` MU
    - `PD` PD
    - `PO` PO
    - `PP` PP
* `GDPRPIAESTIM`
    - `NEG` 
    - `LIM` 
    - `IMP` 
    - `MAX` 
* `GDPRPIAMODIFSMENACE`
    - `CIU` CIU
    - `CPM` CPM
    - `DPM` DPM
    - `LM` LM
    - `LU` LU
    - `MM` MM
    - `PD` PD
    - `PS` PS
* `GDPRPIADISPMENACE`
    - `CID` CID
    - `CIP` CIP
    - `CIS` CIS
    - `CPM` CPM
    - `CPP` CPP
    - `CPS` CPS
    - `DPP` DPP
    - `CPU` CPU
    - `LD` LD
    - `LM` LM
    - `LP` LP
    - `LS` LS
    - `LU` LU
    - `MD` MD
    - `MM` MM
    - `MP` MP
    - `MS` MS
    - `MU` MU
    - `PD` PD
    - `PP` PP
    - `PS` PS

`GdprProcessingActivityHistoric` business object definition
-----------------------------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `row_ref_id` link to **`GdprProcessingActivity`**            | id                                       | yes*     |           |          | Record row ID                                                                    |
| `row_idx`                                                    | int(11)                                  | yes*     | yes       |          | History record index                                                             |
| `created_by_hist`                                            | char(100)                                | yes*     |           |          | Created by                                                                       |
| `created_dt_hist`                                            | datetime                                 | yes*     |           |          | Created date                                                                     |
| `gdprPacPcsId` link to **`GdprProcess`**                     | id                                       |          | yes       |          | Process                                                                          |
| _Ref. `gdprPacPcsId.gdprPcsName`_                            | _char(100)_                              |          |           |          | _Process name_                                                                   |
| `gdprPacName`                                                | char(100)                                | yes*     | yes       |          | Sub-process name                                                                 |
| _Ref. `gdprPacPcsId.gdprPcsId`_                              | _char(11)_                               |          |           |          | -                                                                                |
| `gdprPacRef`                                                 | char(50)                                 |          |           |          | -                                                                                |
| `gdprPacDateCrea`                                            | date                                     |          |           |          | Date de créatioe du traitement                                                   |
| `gdprPacDateMaj`                                             | date                                     |          |           |          | Date de mise à jour du traitement                                                |
| `gdprPacFinalitePrincipale`                                  | char(200)                                |          | yes       |          | Finalité principale                                                              |
| `gdprPacFinaliteSous`                                        | html(1000000)                            |          | yes       |          | Sous-finalité du traitement                                                      |
| `gdprPacUe`                                                  | boolean                                  |          | yes       |          | Hors UE Oui/Non                                                                  |
| `gdprPacMesuresSecuTech`                                     | html(1000000)                            |          | yes       |          | Mesures de sécurité techniques                                                   |
| `gdprPacMesuresSecuOrga`                                     | html(1000000)                            |          | yes       |          | Mesures de sécurité organisationnelles                                           |
| `gdprPacActorActorId` link to **`GdprActor`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `gdprPacActorActorId.usr_login`_                       | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `gdprPacActorActorId.usr_last_name`_                   | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `gdprPacActorActorId.usr_first_name`_                  | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| `gdprPacCatPeople`                                           | multi(50) using `GDPRPACCATPEOPLE` list  |          | yes       |          | -                                                                                |
| `gdprPacPersConOther`                                        | char(200)                                |          | yes       |          | -                                                                                |
| `gdprPacCompGlobal`                                          | int(10)                                  |          |           |          | -                                                                                |
| `gdprPacCompActor`                                           | boolean                                  |          |           |          | Flag that indicates if completion for the "Actor" section is complete            |
| `gdprPacCompFinal`                                           | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompSecurity`                                        | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompData`                                            | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompDest`                                            | boolean                                  |          |           |          | -                                                                                |

### Lists

* `GDPRPACCATPEOPLE`
    - `SAL` Employees
    - `CLI` Clients
    - `PAT` Exploitants
    - `PRO` Prospects
    - `OTR` Other

`GdprRecepient` business object definition
------------------------------------------

Recepient of a processing activity

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprRecepName`                                              | char(100)                                | yes*     | yes       |          | Name of the recepient of the processing activity                                 |
| `gdprRecepType`                                              | enum(10) using `GDPRRECEPTYPE` list      | yes      | yes       |          | Type of recepient                                                                |
| `gdprRecepDesc`                                              | html(1000000)                            |          | yes       |          | Description of the receptient                                                    |
| `gdprRecepOther`                                             | char(100)                                |          | yes       |          | Other kind of recepient                                                          |

### Lists

* `GDPRRECEPTYPE`
    - `INTERNE` Internal
    - `SOUS` Subcontractor
    - `TIERS` Recipients in third countries or international organizations
    - `PART` Institutional or commercial partners
    - `OTHER` Other (Specify)

`GdprRecepPac` business object definition
-----------------------------------------

N-N between recepient and processing activity

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprRecepPacPacId` link to **`GdprProcessingActivity`**     | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprRecepPacPacId.gdprPacName`_                       | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprRecepPacPacId.gdprPacId`_                         | _int(11)_                                |          |           |          | -                                                                                |
| `gdprRecepPacRecepId` link to **`GdprRecepient`**            | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprRecepPacRecepId.gdprRecepName`_                   | _char(100)_                              |          |           |          | _Name of the recepient of the processing activity_                               |
| _Ref. `gdprRecepPacRecepId.gdprRecepType`_                   | _enum(10) using `GDPRRECEPTYPE` list_    |          |           |          | _Type of recepient_                                                              |

### Lists

* `GDPRRECEPTYPE`
    - `INTERNE` Internal
    - `SOUS` Subcontractor
    - `TIERS` Recipients in third countries or international organizations
    - `PART` Institutional or commercial partners
    - `OTHER` Other (Specify)

`GdprTouPac` business object definition
---------------------------------------

N-N for processing activities happening outside of UE

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprTouPacPacId` link to **`GdprProcessingActivity`**       | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprTouPacPacId.gdprPacName`_                         | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprTouPacPacId.gdprPacId`_                           | _int(11)_                                |          |           |          | -                                                                                |
| `gdprTouPacTouId` link to **`GdprTransferOutUe`**            | id                                       | *        | yes       |          | -                                                                                |
| _Ref. `gdprTouPacTouId.gdprTransferOutOrga`_                 | _char(200)_                              |          |           |          | _Organization receiving the processing_                                          |

`GdprTransferOutUe` business object definition
----------------------------------------------

Processing activity processed out of ue

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprTransferOutOrga`                                        | char(200)                                | yes*     | yes       |          | Organization receiving the processing                                            |
| `gdprTransferOutRecepient`                                   | char(100)                                |          | yes       |          | Recepient of processing                                                          |
| `gdprTranferOutCountry`                                      | char(100)                                |          | yes       |          | Country                                                                          |
| `gdprTransferOutGuarantee`                                   | html(1000000)                            |          | yes       |          | Type of guarantees                                                               |
| `gdprTransferOutDoc`                                         | document                                 |          | yes       |          | Link to document                                                                 |

`GdprProcess` business object definition
----------------------------------------

Process

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPcsId`                                                  | char(11)                                 | yes*     |           |          | -                                                                                |
| `gdprPcsName`                                                | char(100)                                | yes      | yes       |          | Process name                                                                     |
| `gdprGenDescription`                                         | html(1000000)                            |          | yes       |          | -                                                                                |

`GdprProcessingActivity` business object definition
---------------------------------------------------

Traitement / Sous-Processus

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPacId`                                                  | int(11)                                  | yes*     | yes       |          | -                                                                                |
| `gdprPacPcsId` link to **`GdprProcess`**                     | id                                       |          | yes       |          | Process                                                                          |
| _Ref. `gdprPacPcsId.gdprPcsName`_                            | _char(100)_                              |          |           |          | _Process name_                                                                   |
| _Ref. `gdprPacPcsId.gdprPcsId`_                              | _char(11)_                               |          |           |          | -                                                                                |
| `gdprPacName`                                                | char(100)                                | yes*     | yes       |          | Sub-process name                                                                 |
| `gdprPacRef`                                                 | char(50)                                 |          |           |          | -                                                                                |
| `gdprPacDateCrea`                                            | date                                     |          |           |          | Date de créatioe du traitement                                                   |
| `gdprPacDateMaj`                                             | date                                     |          |           |          | Date de mise à jour du traitement                                                |
| `gdprPacFinalitePrincipale`                                  | char(200)                                |          | yes       |          | Finalité principale                                                              |
| `gdprPacFinaliteSous`                                        | html(1000000)                            |          | yes       |          | Sous-finalité du traitement                                                      |
| `gdprPacUe`                                                  | boolean                                  |          | yes       |          | Hors UE Oui/Non                                                                  |
| `gdprPacMesuresSecuTech`                                     | html(1000000)                            |          | yes       |          | Mesures de sécurité techniques                                                   |
| `gdprPacMesuresSecuOrga`                                     | html(1000000)                            |          | yes       |          | Mesures de sécurité organisationnelles                                           |
| `gdprPacActorActorId` link to **`GdprActor`**                | id                                       |          | yes       |          | -                                                                                |
| _Ref. `gdprPacActorActorId.usr_login`_                       | _regexp(100)_                            |          |           | yes      | _Login_                                                                          |
| _Ref. `gdprPacActorActorId.usr_last_name`_                   | _char(50)_                               |          |           | yes      | _Last name_                                                                      |
| _Ref. `gdprPacActorActorId.usr_first_name`_                  | _char(50)_                               |          |           | yes      | _First name_                                                                     |
| `gdprPacCatPeople`                                           | multi(50) using `GDPRPACCATPEOPLE` list  |          | yes       |          | -                                                                                |
| `gdprPacPersConOther`                                        | char(200)                                |          | yes       |          | -                                                                                |
| `gdprPacCompGlobal`                                          | int(10)                                  |          |           |          | -                                                                                |
| `gdprPacCompActor`                                           | boolean                                  |          |           |          | Flag that indicates if completion for the "Actor" section is complete            |
| `gdprPacCompFinal`                                           | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompSecurity`                                        | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompData`                                            | boolean                                  |          |           |          | -                                                                                |
| `gdprPacCompDest`                                            | boolean                                  |          |           |          | -                                                                                |

### Lists

* `GDPRPACCATPEOPLE`
    - `SAL` Employees
    - `CLI` Clients
    - `PAT` Exploitants
    - `PRO` Prospects
    - `OTR` Other

`GdprApplication` business object definition
--------------------------------------------

Application (GDPR)

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprAppIdentifier`                                          | regexp(50)                               | yes*     |           |          | -                                                                                |
| `gdprAppName`                                                | char(100)                                | yes      | yes       |          | -                                                                                |
| `gdprAppDescription`                                         | html(1000000)                            |          | yes       |          | -                                                                                |
| `gdprAppOwner`                                               | char(200)                                |          | yes       |          | Name of the application owner                                                    |
| `gdprAppNbUsers`                                             | char(100)                                |          | yes       |          | -                                                                                |

`GdprPrivateData` business object definition
--------------------------------------------

Private Data

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPvdId`                                                  | char(11)                                 | yes*     |           |          | -                                                                                |
| `gdprPvdName`                                                | char(100)                                | yes      | yes       |          | Private data name                                                                |
| `gdprPvdSensitive`                                           | boolean                                  | yes      | yes       |          | -                                                                                |
| `gdprPvdCategory`                                            | enum(30) using `GDPRPVDCATEGORY` list    | yes      | yes       |          | -                                                                                |
| `gdprPvdCat`                                                 | multi(50) using `GDPRPVDCAT` list        | yes      | yes       |          | -                                                                                |
| `gdprPvdSensitiveCat`                                        | multi(50) using `GDPRPVDSENSITIVECAT` list |          | yes       |          | -                                                                                |

### Lists

* `GDPRPVDCATEGORY`
    - `EMPLOYEE` Employee
    - `BUSINESS` Business
    - `CLIENT` Client
* `GDPRPVDCAT`
    - `ID` Identification
    - `PERS` Personnal
    - `ECO` Economic
    - `LOGIN` Login
    - `LOCAL` Location
* `GDPRPVDSENSITIVECAT`
    - `RAC` Racial origin
    - `POL` Political views
    - `REL` Religious convictions
    - `SYN` Union membership
    - `GEN` Genetic
    - `BIO` Biometric
    - `SEX` Sexual orientation
    - `CRIM` Criminal convictions
    - `NIR` National identifier

`GdprPvdPvd` business object definition
---------------------------------------

Private Data Hierarchy

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPvdPvdEnclosingId` link to **`GdprPrivateData`**        | id                                       | yes*     | yes       |          | Enclosing private data                                                           |
| _Ref. `gdprPvdPvdEnclosingId.gdprPvdName`_                   | _char(100)_                              |          |           |          | _Private data name_                                                              |
| _Ref. `gdprPvdPvdEnclosingId.gdprPvdId`_                     | _char(11)_                               |          |           |          | -                                                                                |
| `gdprPvdPvdElementId` link to **`GdprPrivateData`**          | id                                       | yes*     | yes       |          | Element private data                                                             |
| _Ref. `gdprPvdPvdElementId.gdprPvdName`_                     | _char(100)_                              |          |           |          | _Private data name_                                                              |
| _Ref. `gdprPvdPvdElementId.gdprPvdId`_                       | _char(11)_                               |          |           |          | -                                                                                |

`GdprPacPvd` business object definition
---------------------------------------

Link between Processing Activity and Private Data

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPiaPacPvdId` link to **`GdprPia`**                      | id                                       |          | yes       |          | -                                                                                |
| `gdprPacPvdPacId` link to **`GdprProcessingActivity`**       | id                                       | yes      | yes       |          | Sub-Process                                                                      |
| _Ref. `gdprPacPvdPacId.gdprPacPcsId`_                        | _id_                                     |          |           |          | _Process_                                                                        |
| _Ref. `gdprPacPcsId.gdprPcsName`_                            | _char(100)_                              |          |           |          | _Process name_                                                                   |
| _Ref. `gdprPacPvdPacId.gdprPacName`_                         | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprPacPvdPacId.gdprPacId`_                           | _int(11)_                                |          |           |          | -                                                                                |
| `gdprPacPvdPvdId` link to **`GdprPrivateData`**              | id                                       | yes      | yes       |          | Private Data                                                                     |
| _Ref. `gdprPacPvdPvdId.gdprPvdName`_                         | _char(100)_                              |          |           |          | _Private data name_                                                              |
| _Ref. `gdprPacPvdPvdId.gdprPvdId`_                           | _char(11)_                               |          |           |          | -                                                                                |
| _Ref. `gdprPacPvdPvdId.gdprPvdCat`_                          | _multi(50) using `GDPRPVDCAT` list_      |          |           |          | -                                                                                |
| `gdprPacPvdVolume`                                           | int(10)                                  |          | yes       |          | Volume                                                                           |
| `gdprPacPvdConsent`                                          | boolean                                  | yes      | yes       |          | Consent?                                                                         |
| `gdprPacPvdPerformanceOfaContact`                            | boolean                                  | yes      | yes       |          | Performance of a contact                                                         |
| `gdprPacPvdComplianceWithAlegalObligation`                   | boolean                                  | yes      | yes       |          | Compliance with a legal obligation                                               |
| `gdprImPacPvdProtectVitalInterests`                          | boolean                                  | yes      | yes       |          | Protect vital interests of an individual                                         |
| `gdprPacPvdPublicInterest`                                   | boolean                                  | yes      | yes       |          | Public interest                                                                  |
| `gdprPacPvdLegitimateInterest`                               | boolean                                  | yes      | yes       |          | Legitimate interest                                                              |
| `gdprPacPvdDelai`                                            | date                                     |          | yes       |          | -                                                                                |
| `gdprPacPvdUid`                                              | char(10)                                 | yes*     | yes       |          | -                                                                                |

### Lists

* `GDPRPVDCAT`
    - `ID` Identification
    - `PERS` Personnal
    - `ECO` Economic
    - `LOGIN` Login
    - `LOCAL` Location

`GdprEntApp` business object definition
---------------------------------------



### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprEntAppAppId` link to **`GdprApplication`**              | id                                       | *        | yes       |          | Software component                                                               |
| _Ref. `gdprEntAppAppId.gdprAppName`_                         | _char(100)_                              |          |           |          | -                                                                                |
| _Ref. `gdprEntAppAppId.gdprAppIdentifier`_                   | _regexp(50)_                             |          |           |          | -                                                                                |
| `gdprEntAppEntId` link to **`GdprEntity`**                   | id                                       | *        | yes       |          | Entity                                                                           |
| _Ref. `gdprEntAppEntId.gdprEntName`_                         | _char(100)_                              |          |           |          | -                                                                                |

`GdprPacPvdEnt` business object definition
------------------------------------------

Link between Private Data and Entity

### Fields

| Name                                                         | Type                                     | Required | Updatable | Personal | Description                                                                      |
|--------------------------------------------------------------|------------------------------------------|----------|-----------|----------|----------------------------------------------------------------------------------|
| `gdprPacPvdEntPacPvdId` link to **`GdprPacPvd`**             | id                                       | yes*     | yes       |          | Private Data                                                                     |
| _Ref. `gdprPacPvdEntPacPvdId.gdprPacPvdUid`_                 | _char(10)_                               |          |           |          | -                                                                                |
| _Ref. `gdprPacPvdEntPacPvdId.gdprPacPvdPacId`_               | _id_                                     |          |           |          | _Sub-Process_                                                                    |
| _Ref. `gdprPacPvdPacId.gdprPacName`_                         | _char(100)_                              |          |           |          | _Sub-process name_                                                               |
| _Ref. `gdprPacPvdPacId.gdprPacPcsId`_                        | _id_                                     |          |           |          | _Process_                                                                        |
| _Ref. `gdprPacPcsId.gdprPcsName`_                            | _char(100)_                              |          |           |          | _Process name_                                                                   |
| _Ref. `gdprPacPvdEntPacPvdId.gdprPacPvdPvdId`_               | _id_                                     |          |           |          | _Private Data_                                                                   |
| _Ref. `gdprPacPvdPvdId.gdprPvdName`_                         | _char(100)_                              |          |           |          | _Private data name_                                                              |
| _Ref. `gdprPacPvdPvdId.gdprPvdCat`_                          | _multi(50) using `GDPRPVDCAT` list_      |          |           |          | -                                                                                |
| `gdprPacPvdEntEntId` link to **`GdprEntity`**                | id                                       | yes*     | yes       |          | Entity                                                                           |
| _Ref. `gdprPacPvdEntEntId.gdprEntName`_                      | _char(100)_                              |          |           |          | -                                                                                |
| `gdprPacPvdEntType`                                          | enum(25) using `GDPRPACPVDENTTYPE` list  | yes*     | yes       |          | Type                                                                             |
| `gdprPacPvdEntChannel`                                       | enum(20) using `GDPRPACPVDENTCHANNEL` list |          | yes       |          | Channel                                                                          |

### Lists

* `GDPRPVDCAT`
    - `ID` Identification
    - `PERS` Personnal
    - `ECO` Economic
    - `LOGIN` Login
    - `LOCAL` Location
* `GDPRPACPVDENTTYPE`
    - `PROVIDING` Providing
    - `CONSUMING` Consuming
    - `PROCESSING` Processing
* `GDPRPACPVDENTCHANNEL`
    - `UI` User interface
    - `MANUAL` Manual
    - `WS` Webservices
    - `FTP` (S)FTP
    - `OTHER` Others

`GdprCreatePac` external object definition
------------------------------------------




`GdprCreatePcs` external object definition
------------------------------------------




