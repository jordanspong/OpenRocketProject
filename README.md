## OpenRocketProject
A repository for the Student Team for Alberta Rocketry Research led project for the software OpenRocket

(From Lochlin King, 'OpenRocket Module Project Outline')

# Project overview:

Current methods of DLE involve laborious manual data entry and data pulling from multiple sources. However, most of the information required to compute rocket design loads already exists in the OpenRocket software -- in the background. Therefore, it is possible to develop a DLE module for OpenRocket that simply computes the design loads of a given rocket design following the setup and execution of a trajectory simulation in OpenRocket. 

# What is the purpose of a Design Loads Estimation Module?

Before a DLE module can be integrated into OpenRocket, an understanding of what the DLE must accomplish is required. The purpose of the DLE is to take as input, the flight conditions, and rocket geometry and with this information, discretize the rocket’s geometry into a sufficient number of finite elements. For each element, the mass, center of gravity, center of pressure, and stability derivatives are computed. With this information, a built-in solver can then use a marching solution to compute the internal axial, shear, and moment forces acting on each element and thereby generate axial, shear, and bending moment diagrams.

Thankfully, the mathematics and corresponding VBA implementation already exist in the rocketry community. The current implementation however, is cumbersome. What this project therefore aims to do is automate this cumbersome activity to accelerate the design and optimization of new launch vehicle concepts. Upon successful completion of this venture, an estimated time savings of 8 hours will be realized and a higher fidelity solution, automatic. 

## Stages of a DLE module:

Pre-processor: The collection of all necessary information required by the solver to compute the rocket’s design loads

Data input via the OpenRocket GUI 
Ask the user for desired number of divisions in the mesh
Divide the rocket into the desired number of divisions, compute the coordinates of each element and store as a list.
Identify which elements are contained within the length of the fin root chord and preallocate the fraction of load each element along this length with experience 
Compute the mass, center of gravity, center of pressure, and stability derivatives for each element. 
Computation of the mass will be the most difficult parameter to calculate. A method of mass calculation assuming uniform density within each element will have to be developed. 
The calculation of the center of pressures and the stability derivatives require the use of the Barrowman equations. Depending on whether the rocket is in the subsonic, transonic, or supersonic regime, the appropriate formulation of the Barrowman equations must be  identified and used to compute these parameters.
All flight conditions will be pulled from their existing locations in the OpenRocket code and stored in a list for use in the solver step.

Solver: An iterative procedure that will use the data collected with the preprocessor to compute the axial, shear, and moment forces for each element and store them in a list 
Compute the axial loads by converting the existing VBA code into Java for the airframe
Compute the shear loads by converting the existing VBA code into Java for the airframe
Compute the moment loads by converting the existing VBA code into Java for the airframe
Compute the shear and moment forces for the fins  by converting the existing VBA code into Java

Post-processor: The job of the post processor is to convert the solution vectors (read: lists of solutions) into results the user will see.

Generation of axial diagrams as a function of distance relative to the nose cone tip (x=0).
Generation of shear diagrams as a function of distance relative to the nose cone tip (x=0).
Generation of bending moment diagrams as a function of distance relative to the nose cone tip (x=0).
Generate Shear and bending moment plots for the fins
Generation of solution vectors into CSV format and adding them to the list of variables to export in the plot/export window in OpenRocket 
Print out the maximum axial, shear, and bending moment magnitudes and their respective x stations along the rocket for both the airframe and the fins
Integrate into plot window within OpenRocket

# How will success be measured in this project?

The module runs automatically without additional assistance from the OpenRocket user.
The time taken to complete a single design iteration (model setup, flight condition input, and printed results) is less than an hour
The module produces results that match the current values obtained manually from Charles Hoults’ BENDIT7.xls spreadsheet.
