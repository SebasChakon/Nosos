Guía de actividad: Desarrollo de aplicación web para gestión de notas
académicas
1. Objetivo
Desarrollar una aplicación web para la gestión de notas académicas de un colegio,
integrando HTML, CSS, JavaScript, Programación Orientada a Objetos (POO),
bases de datos y principios de UX/UI.
La aplicación deberá permitir registrar las notas de un estudiante, calcular su promedio
cuantitativo y generar automáticamente una valoración cualitativa de acuerdo con el
resultado obtenido.
2. Descripción de la aplicación
El estudiante deberá desarrollar una aplicación web que permita registrar la información
académica de un estudiante mediante el ingreso de cuatro notas.
Cada nota deberá encontrarse en una escala de 0.0 a 5.0.
La aplicación deberá calcular automáticamente el promedio de las cuatro notas y
mostrar dos resultados:
•
•

Resultado cuantitativo: promedio obtenido entre 0.0 y 5.0.
Resultado cualitativo: valoración del rendimiento académico.

3. Clasificación del rendimiento
La aplicación deberá utilizar la siguiente escala:
Promedio cuantitativo

Resultado cualitativo

0.0 – 2.9

Rendimiento insuficiente

3.0 – 3.9

Aprobado

4.0 – 4.5

Aprobado con sobresaliente

4.6 – 5.0

Aprobado con excelente

El sistema deberá determinar automáticamente la clasificación correspondiente.
Por ejemplo, si el estudiante obtiene un promedio de 4.3, la aplicación deberá mostrar:

Promedio: 4.3
Estado: Aprobado
Rendimiento: Aprobado con sobresaliente
4. Requisitos tecnológicos
La aplicación deberá desarrollarse integrando obligatoriamente los siguientes
elementos:
4.1 HTML
Utilizar HTML para construir la estructura de la aplicación.
Como mínimo deberá contener:
•
•
•
•
•
•
•

Formulario de registro.
Campo para nombre del estudiante.
Cuatro campos para las notas.
Botón para calcular.
Botón para guardar.
Área para mostrar resultados.
Sección para consultar los registros almacenados.

4.2 CSS
Utilizar CSS para desarrollar la presentación visual de la aplicación.
Se deberá trabajar:
•
•
•
•
•
•
•
•

Distribución de los elementos.
Tipografía.
Espaciado.
Botones.
Formularios.
Tablas o tarjetas de resultados.
Diseño adaptable o responsive.
Organización visual de la información.

No se deberá entregar una interfaz basada únicamente en elementos HTML sin diseño.
4.3 JavaScript
JavaScript deberá encargarse de la lógica de funcionamiento de la aplicación.
Como mínimo deberá permitir:

•
•
•
•
•
•
•
•

Capturar los datos del formulario.
Validar las cuatro notas.
Calcular el promedio.
Determinar la aprobación.
Determinar el resultado cualitativo.
Mostrar los resultados en pantalla.
Gestionar las acciones del usuario.
Interactuar con la base de datos.

5. Programación Orientada a Objetos (POO)
La aplicación deberá implementar conceptos de Programación Orientada a Objetos
mediante JavaScript.
El estudiante deberá crear, como mínimo, una clase relacionada con el estudiante o
sus calificaciones.
Por ejemplo, conceptualmente se podrá trabajar con una clase:
Estudiante
que contenga información como:
•
•
•
•
•
•
•

Nombre.
Nota 1.
Nota 2.
Nota 3.
Nota 4.
Promedio.
Resultado cualitativo.

La clase deberá contener métodos para realizar operaciones como:
•
•
•

Calcular promedio.
Determinar aprobación.
Determinar rendimiento cualitativo.

El objetivo es demostrar que la lógica principal de la aplicación está organizada
mediante POO y no únicamente mediante funciones independientes.
6. Base de datos
La aplicación deberá utilizar una base de datos para almacenar la información
registrada.


Como mínimo deberá almacenar:
•
•
•
•
•
•
•
•

Identificador del estudiante.
Nombre.
Nota 1.
Nota 2.
Nota 3.
Nota 4.
Promedio.
Resultado cualitativo.

La información deberá permanecer almacenada después de realizar el registro.
El estudiante podrá utilizar la tecnología de base de datos trabajada durante el curso,
de acuerdo con las indicaciones del docente.
7. Operaciones con la base de datos
La aplicación deberá permitir como mínimo:
Registrar: guardar un estudiante con sus cuatro notas.
Consultar: visualizar los estudiantes registrados.
Actualizar: modificar las notas o información de un estudiante.
Eliminar: eliminar un registro cuando sea necesario.
De esta manera, el estudiante deberá demostrar el funcionamiento básico de las
operaciones CRUD.
8. UX – Experiencia de usuario
La aplicación deberá aplicar principios básicos de UX (User Experience).
El estudiante deberá procurar que:
•
•
•
•
•
•
•

El usuario comprenda fácilmente qué debe hacer.
Los campos tengan nombres claros.
Los mensajes de error sean comprensibles.
El proceso de registro sea sencillo.
Los resultados sean fáciles de interpretar.
La información importante tenga una jerarquía visual adecuada.
El usuario reciba retroalimentación después de cada operación.


La aplicación deberá evitar procesos innecesariamente complejos.
9. UI – Interfaz de usuario
La interfaz deberá aplicar principios básicos de UI (User Interface).
Se deberá prestar atención a:
•
•
•
•
•
•
•
•
•
•

Colores.
Tipografía.
Tamaños.
Botones.
Formularios.
Espaciado.
Iconos, si se utilizan.
Organización de la información.
Consistencia visual.
Diseño responsive.

La interfaz deberá presentar una apariencia coherente y profesional.
10. Flujo general de la aplicación
El funcionamiento esperado será:
Usuario
↓
Formulario de registro
↓
Ingreso de cuatro notas
↓
Validación
↓
Objeto Estudiante – POO
↓

Cálculo del promedio
↓
Clasificación cualitativa
↓
Presentación del resultado
↓
Almacenamiento en base de datos
↓
Consulta de registros
11. Validaciones obligatorias
La aplicación deberá validar:
•
•
•
•
•
•
•

Que el nombre del estudiante sea obligatorio.
Que las cuatro notas sean obligatorias.
Que las notas sean valores numéricos.
Que ninguna nota sea inferior a 0.0.
Que ninguna nota sea superior a 5.0.
Que no se puedan guardar registros incompletos.
Que se informe claramente al usuario cuando exista un error.

12. Pruebas de funcionamiento
El estudiante deberá realizar pruebas que permitan comprobar el funcionamiento de la
aplicación.
Prueba 1 – Rendimiento insuficiente
Registrar notas cuyo promedio sea inferior a 3.0.
Resultado esperado: Rendimiento insuficiente.
Prueba 2 – Aprobado
Registrar notas cuyo promedio esté entre 3.0 y 3.9.

Resultado esperado: Aprobado.
Prueba 3 – Aprobado con sobresaliente
Registrar notas cuyo promedio esté entre 4.0 y 4.5.
Resultado esperado: Aprobado con sobresaliente.
Prueba 4 – Aprobado con excelente
Registrar notas cuyo promedio esté entre 4.6 y 5.0.
Resultado esperado: Aprobado con excelente.
Prueba 5 – Nota inválida
Ingresar una nota menor a 0.0 o superior a 5.0.
Resultado esperado: El sistema deberá impedir el registro y mostrar un mensaje de
validación.
Prueba 6 – Base de datos
Registrar un estudiante y posteriormente consultar los registros.
Resultado esperado: El estudiante deberá aparecer almacenado correctamente.
13. Entregables
El estudiante deberá entregar:
1. Código fuente HTML.
2. Código CSS.
3. Código JavaScript.
4. Implementación de POO.
5. Base de datos.
6. Operaciones CRUD.
7. Aplicación web funcionando.
8. Evidencias de las pruebas realizadas.
9. Evidencias de los registros almacenados en la base de datos.
10. Evidencias de la interfaz desarrollada.
11. Breve explicación de las decisiones de UX/UI utilizadas.
14. Evidencias

El estudiante deberá presentar evidencias que permitan verificar:
•
•
•
•
•
•
•
•
•
•
•

Formulario de registro.
Ingreso de las cuatro notas.
Cálculo del promedio.
Resultado cuantitativo.
Resultado cualitativo.
Validaciones.
Registro en la base de datos.
Consulta de estudiantes.
Actualización de información.
Eliminación de registros.
Funcionamiento de la interfaz.

15. Criterios de evaluación
Criterio

Porcentaje

HTML y estructura de la aplicación

10%

CSS y diseño de interfaz

10%

JavaScript y funcionamiento

15%

Programación Orientada a Objetos

15%

Base de datos y operaciones CRUD

20%

Cálculo y clasificación de notas

10%

UX/UI

10%

Pruebas y evidencias

10%

Total

100%

16. Producto final
El estudiante deberá entregar una aplicación web funcional para la gestión de notas
académicas, en la cual se evidencie la integración de:
HTML + CSS + JavaScript + POO + Base de Datos + CRUD + UX/UI


La aplicación deberá permitir registrar las cuatro notas de un estudiante, calcular
automáticamente el promedio de 0.0 a 5.0, determinar si aprueba a partir de 3.0 y
mostrar el resultado cuantitativo acompañado de su correspondiente valoración
cualitativa.
El resultado final deberá demostrar no solamente que el cálculo funciona, sino que el
estudiante es capaz de integrar diferentes tecnologías y conceptos para construir una
solución web funcional, organizada y orientada al usuario.
