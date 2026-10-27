Pod::Spec.new do |s|
  s.name             = 'APIVerveCronExpressionParser'
  s.version          = '1.2.3'
  s.summary          = 'Cron Expression Parser decodes 5-field and 6-field cron expressions into human-readable schedules.'
  s.description      = <<-'DESC'
Cron Expression Parser decodes 5-field and 6-field cron expressions into human-readable schedules. Pass any cron string to verify syntax, read plain-language timing explanations, and get the next five execution timestamps.

This iOS/macOS SDK provides a convenient way to access the Cron Expression Parser from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/cronparser?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/cronparser-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveCronExpressionParser/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
