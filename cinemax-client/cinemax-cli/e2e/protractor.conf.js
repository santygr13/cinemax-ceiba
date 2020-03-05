const { SpecReporter } = require('jasmine-spec-reporter');


/**
 * @type { import("protractor").Config }
 */

exports.config = {

  framework: 'jasmine',
  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['src/pages/principaltest.ts','src/pages/salacinetest.ts','src/pages/peliculatest.ts','src/pages/reservatest.ts'],
  capabilities: {
    browserName: "firefox"
  },

  
  jasmineNodeOpts: {
    showColors: true,
    defaultTimeoutInterval: 30000,
    print: function () { }
  },
  onPrepare() {
    require('ts-node').register({
      project: require('path').join(__dirname, './tsconfig.json')
    });
    const SpecReporter = require('jasmine-spec-reporter').SpecReporter;
    jasmine.getEnv().addReporter(new SpecReporter({ spec: { displayStacktrace: true } }));

  }

}

