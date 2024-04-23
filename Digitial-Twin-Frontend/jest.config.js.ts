module.exports = {
    preset: 'jest-preset-angular',
    setupFilesAfterEnv: ['<rootDir>/src/setup-jest.ts'],
    testPathIgnorePatterns: [
        "<rootDir>/node_modules/",
        "<rootDir>/dist/"
    ],
    globals: {
        'ts-jest': {
            tsconfig: '<rootDir>/tsconfig.spec.json',
            stringifyContentPathRegex: '\\.html$',
            diagnostics: false
        }
    },
    moduleNameMapper: {
        '@app/(.*)': '<rootDir>/src/app/$1',
        '@assets/(.*)': '<rootDir>/src/assets/$1',
        '@env': '<rootDir>/src/environments/environment',
    }
};
