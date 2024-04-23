import type { Config } from 'jest';

const config: Config = {
    preset: 'jest-preset-angular',
    setupFilesAfterEnv: ['<rootDir>/src/setup-jest.ts'],
    globals: {
        'ts-jest': {
            tsconfig: '<rootDir>/tsconfig.spec.json',
            stringifyContentPathRegex: '\\.html$',
            diagnostics: {
                warnOnly: true
            }
        }
    },
    moduleNameMapper: {
        '@app/(.*)': '<rootDir>/src/app/$1',
        '@assets/(.*)': '<rootDir>/src/assets/$1',
        '@env': '<rootDir>/src/environments/environment'
    },
    transform: {
        '^.+\\.(ts|html)$': 'ts-jest'
    },
    testPathIgnorePatterns: ['<rootDir>/node_modules/', '<rootDir>/dist/']
};

export default config;
