clear;
figure_num = 1;

% Define Constants
h = 6.626e-34;
c = 3e8;
Fs = 6.79e-5;
T = 5800;
kB = 1.381e-23;

% Create Wavelength vector from 0.1 micrometers to 5 micrometers
wavelength = linspace(0.0000001, 0.000005, 2500);

% Create vector of solar irradiance values givenS = trapz(wavelength, I) the wavelength vector
exponent = exp((h.*c)./(wavelength.*kB.*T));
I = (2.*Fs.*h.*c.^2)./(wavelength.^5.*(exponent-1));

% Use a trapezoidal approximation to calculate the solar constant
S = trapz(wavelength, I)

% Plot the Solar Irradiance (I) vs. Wavelength
figure(figure_num);
plot(wavelength, I)
xlabel("Wavelength (m)")
ylabel("Solar Irradiance (W/m^3)")
title("Solar Irradiance vs. Wavelength")

figure_num = figure_num + 1;

% Create vector representing photon flux density given the wavelength
% vector
v = c./wavelength;
E = h.*v;
PhotonFluxDensity = I./E;

% Plot the Photon Flux Density vs. Wavelength
figure(figure_num);
plot(wavelength,PhotonFluxDensity)
xlabel("Wavelength (m)")
ylabel("Photon Flux Density (1/m^2/s)")
title("Photon Flux Density vs Wavelength")

% Calculate the total Photon Flux given the wavelength vector
PhotonFlux = trapz(wavelength, PhotonFluxDensity)